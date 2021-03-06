package com.xmg.mybatis.test;

import com.xmg.mybatis.many2one.Department;
import com.xmg.mybatis.many2one.DepartmentMapper;
import com.xmg.mybatis.many2one.Employee;
import com.xmg.mybatis.many2one.EmployeeMapper;
import com.xmg.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Many2OneTest {

    private EmployeeMapper empMapper;
    private DepartmentMapper deptMapper;


    public Many2OneTest(){
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
        Department d = new Department();
        d.setName("d");
        e.setDept(d);

        deptMapper.add(d);
        empMapper.add(e);

        session.commit();
        session.close();
    }

    @Test
    public void testGet(){

        SqlSession session = MybatisUtil.openSession();

        empMapper = session.getMapper(EmployeeMapper.class);

        // 这里无法从employee拿到dept,因为没有在EmployeeMapper中添加association关联关系
        Employee e = empMapper.get(1L);
        Department d = e.getDept();
        System.out.println(e);
        System.out.println(d);

        session.close();
    }



}
