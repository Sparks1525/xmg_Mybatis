package test.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import test.many2many.Student;
import test.many2many.StudentMapper;
import test.many2many.Teacher;
import test.many2many.TeacherMapper;
import test.util.MybatisUtil;

import java.util.List;
import java.util.Set;

public class Many2ManyTest {

    TeacherMapper teacherMapper;
    StudentMapper studentMapper;


    @Test
    public void testSave() {

        SqlSession session = MybatisUtil.openSession();
        teacherMapper = session.getMapper(TeacherMapper.class);
        studentMapper = session.getMapper(StudentMapper.class);



        Student s1 = new Student();
        s1.setName("s1");
        Student s2 = new Student();
        s2.setName("s2");

        Teacher t1 = new Teacher();
        t1.setName("t1");
        t1.getStudents().add(s1);
        t1.getStudents().add(s2);
        Teacher t2 = new Teacher();
        t2.setName("t2");
        t2.getStudents().add(s1);
        t2.getStudents().add(s2);

        teacherMapper.add(t1);
        teacherMapper.add(t2);

        studentMapper.add(s1);
        studentMapper.add(s2);


        System.out.println(s1.getId());
        System.out.println(s2.getId());
        System.out.println(t1.getId());
        System.out.println(t2.getId());

        for(Student s : t1.getStudents()){
            teacherMapper.resovleRelation(t1.getId(),s.getId());
        }

        for(Student s : t2.getStudents()){
            teacherMapper.resovleRelation(t2.getId(),s.getId());
        }


        session.commit();
        session.close();

    }

    @Test
    public void testSave2() {

        SqlSession session = MybatisUtil.openSession();
        teacherMapper = session.getMapper(TeacherMapper.class);
        studentMapper = session.getMapper(StudentMapper.class);



        Student s1 = new Student();
        s1.setName("s1");
        Student s2 = new Student();
        s2.setName("s2");

        Teacher t1 = new Teacher();
        t1.setName("t1");
        t1.getStudents().add(s1);
        t1.getStudents().add(s2);
        Teacher t2 = new Teacher();
        t2.setName("t2");
        t2.getStudents().add(s1);
        t2.getStudents().add(s2);

        teacherMapper.insertAndgetkey(t1);
        teacherMapper.insertAndgetkey(t2);

        studentMapper.insertAndgetkey(s1);
        studentMapper.insertAndgetkey(s2);

        System.out.println(s1.getId());
        System.out.println(s2.getId());
        System.out.println(t1.getId());
        System.out.println(t2.getId());


        for(Student s : t1.getStudents()){
            teacherMapper.resovleRelation(t1.getId(),s.getId());
        }

        for(Student s : t2.getStudents()){
            teacherMapper.resovleRelation(t2.getId(),s.getId());
        }

        session.commit();
        session.close();

    }

    @Test
    public void testGet() {
        SqlSession session = MybatisUtil.openSession();
        teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher t = teacherMapper.get(1);
        System.out.println(t);

        Set<Student> students = t.getStudents();
        for (Student s : students) {
            System.out.println(s);
        }
        session.close();
    }

    @Test
    public void testList() {
        SqlSession session = MybatisUtil.openSession();
        teacherMapper = session.getMapper(TeacherMapper.class);


        List<Teacher> ts = teacherMapper.list();
        for (Teacher t : ts) {
            System.out.println(t);
            Set<Student> students = t.getStudents();
            for (Student s : students) {
                System.out.println(s);
            }
        }
        session.close();
    }

    @Test
    public void testGet2() {
        SqlSession session = MybatisUtil.openSession();
        teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher t = teacherMapper.get2(1);
        System.out.println(t);

        Set<Student> students = t.getStudents();
        for (Student s : students) {
            System.out.println(s);
        }
        session.close();
    }

    @Test
    public void testList2() {
        SqlSession session = MybatisUtil.openSession();
        teacherMapper = session.getMapper(TeacherMapper.class);


        List<Teacher> ts = teacherMapper.list2();
        for (Teacher t : ts) {
            System.out.println(t);
            Set<Student> students = t.getStudents();
            for (Student s : students) {
                System.out.println(s);
            }
        }
        session.close();
    }
}
