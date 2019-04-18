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

        long tId1 = (long)teacherMapper.insertAndgetkey(t1);
        long tId2 = (long)teacherMapper.insertAndgetkey(t2);

        long sId1 = (long)studentMapper.insertAndgetkey(s1);
        long sId2 = (long)studentMapper.insertAndgetkey(s2);

        System.out.println(tId1);
        System.out.println(tId2);
        System.out.println(sId1);
        System.out.println(sId2);


//        teacherMapper.resovleRelation(tId1,sId1);
//        teacherMapper.resovleRelation(tId1,sId2);
//        teacherMapper.resovleRelation(tId2,sId1);
//        teacherMapper.resovleRelation(tId2,sId2);

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
