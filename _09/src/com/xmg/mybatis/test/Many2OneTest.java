package com.xmg.mybatis.test;

import com.xmg.mybatis.many2one.Department;
import com.xmg.mybatis.many2one.DepartmentMapper;
import com.xmg.mybatis.many2one.Employee;
import com.xmg.mybatis.many2one.EmployeeMapper;
import com.xmg.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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
        deptMapper = session.getMapper(DepartmentMapper.class);

        Employee e = empMapper.get(1L);
        Department d = e.getDept();

        System.out.println(e);
        System.out.println(d);

        session.close();

    }

    @Test
    public void testList(){
        SqlSession session = MybatisUtil.openSession();

        empMapper = session.getMapper(EmployeeMapper.class);
        deptMapper = session.getMapper(DepartmentMapper.class);

        List<Employee> es = empMapper.list();
        for(Employee e : es){
            System.out.println(e.getName()+"      " + e.getDept().getName());
        }
        session.close();

    }

    @Test
    public void testGet2(){
        SqlSession session = MybatisUtil.openSession();

        empMapper = session.getMapper(EmployeeMapper.class);

        empMapper.get(1L);
        session.clearCache();
        empMapper.get(1L);

        session.close();

    }

    @Test
    public void testGet3(){
        SqlSession session = MybatisUtil.openSession();

        empMapper = session.getMapper(EmployeeMapper.class);
        empMapper.get(1L);
        session.close();

        session = MybatisUtil.openSession();
        empMapper = session.getMapper(EmployeeMapper.class);
        empMapper.get(1L);
        session.close();
    }

    @Test
    public void testAutoComplate(){
        SqlSession session = MybatisUtil.openSession();

        empMapper = session.getMapper(EmployeeMapper.class);


        List<Employee> es = empMapper.autoCompateList();
        for(Employee e : es){
            System.out.println(e.getName()+"      " + e.getDept().getName());
        }
        session.close();

    }
}
