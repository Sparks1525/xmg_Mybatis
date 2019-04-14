package com.xmg.mybatis.test;


import com.xmg.mybatis.one2many.Department;
import com.xmg.mybatis.one2many.DepartmentMapper;
import com.xmg.mybatis.one2many.Employee;
import com.xmg.mybatis.one2many.EmployeeMapper;
import com.xmg.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class One2ManyTest {

    private EmployeeMapper empMapper;
    private DepartmentMapper deptMapper;


    public One2ManyTest(){
        empMapper = MybatisUtil.openSession().getMapper(EmployeeMapper.class);
        deptMapper = MybatisUtil.openSession().getMapper(DepartmentMapper.class);
    }

    @Test
    public void testSave(){

        SqlSession session = MybatisUtil.openSession();

        empMapper = session.getMapper(EmployeeMapper.class);
        deptMapper = session.getMapper(DepartmentMapper.class);

        Employee e = new Employee();
        e.setName("e");
        Employee e2 = new Employee();
        e2.setName("e2");
        Department d = new Department();
        d.setName("d");
        d.getEmps().add(e);
        d.getEmps().add(e2);

        for(Employee temp : d.getEmps()){
            deptMapper.updateRelation(temp.getId(), d.getId());
        }


        deptMapper.add(d);
        empMapper.add(e);
        empMapper.add(e2);

        session.commit();
        session.close();
    }


    @Test
    public void testGet(){
        SqlSession session = MybatisUtil.openSession();

        deptMapper = session.getMapper(DepartmentMapper.class);

        Department d = deptMapper.get(1L);
        List<Employee> es=d.getEmps();
        System.out.println(d);
        System.out.println(es);


        session.close();

    }


}
