package com.xmg.mybatis.test;


import com.xmg.mybatis.many2many.Student;
import com.xmg.mybatis.many2many.StudentMapper;
import com.xmg.mybatis.many2many.Teacher;
import com.xmg.mybatis.many2many.TeacherMapper;
import com.xmg.mybatis.one2many.Department;
import com.xmg.mybatis.one2many.DepartmentMapper;
import com.xmg.mybatis.one2many.Employee;
import com.xmg.mybatis.one2many.EmployeeMapper;
import com.xmg.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class Many2ManyTest {

    private TeacherMapper tMapper;
    private StudentMapper sMapper;


    @Test
    public void testSave(){

        SqlSession session = MybatisUtil.openSession();

        tMapper = session.getMapper(TeacherMapper.class);
        sMapper = session.getMapper(StudentMapper.class);


        Student s1 = new Student();
        s1.setName("s1");

        Student s2 = new Student();
        s1.setName("s2");

        Teacher t1 = new Teacher();
        t1.setName("t1");

        Teacher t2 = new Teacher();
        t1.setName("t2");

        t1.getStudents().add(s1);
        t1.getStudents().add(s2);
        t2.getStudents().add(s1);
        t2.getStudents().add(s2);

        tMapper.add(t1);
        tMapper.add(t2);
        sMapper.add(s1);
        sMapper.add(s2);

        for(Student temp : t2.getStudents()){
            tMapper.resovleRelation(t2.getId(),temp.getId());
        }

        session.commit();
        session.close();
    }


    @Test
    public void testGet(){
        SqlSession session = MybatisUtil.openSession();
        tMapper = session.getMapper(TeacherMapper.class);

        Teacher t1 = tMapper.get(1L);
        Set<Student> ss = t1.getStudents();

        System.out.println(t1);
        System.out.println(ss);

        session.close();

    }


}
