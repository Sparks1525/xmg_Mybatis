package test.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import test.many2one.Department;
import test.many2one.DepartmentMapper;
import test.many2one.Employee;
import test.many2one.EmployeeMapper;
import test.util.MybatisUtil;

import java.util.List;

public class Many2OneTest {

    DepartmentMapper departmentMapper;
    EmployeeMapper employeeMapper;

    @Test
    public void testSave(){
        SqlSession session = MybatisUtil.openSession();
        departmentMapper = session.getMapper(DepartmentMapper.class);
        employeeMapper = session.getMapper(EmployeeMapper.class);

        Department d1 = new Department();
        d1.setName("d1");

        Department d2 = new Department();
        d2.setName("d2");

        Employee e1 = new Employee();
        e1.setName("e1");
        e1.setDept(d1);

        Employee e2 = new Employee();
        e2.setName("e2");
        e2.setDept(d2);

        departmentMapper.add(d1);
        departmentMapper.add(d2);

        employeeMapper.add(e1);
        employeeMapper.add(e2);

        session.commit();
        session.close();
    }

    @Test
    public void testGet(){
        SqlSession session = MybatisUtil.openSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee e = employeeMapper.get(1);
        System.out.println(e);
        System.out.println(e.getDept());
        session.close();
    }

    @Test
    public void testList(){
        SqlSession session = MybatisUtil.openSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Employee> es = employeeMapper.list();
        for(Employee e : es){
            System.out.println(e);
            System.out.println(e.getDept());
        }

        session.close();
    }

    @Test
    public void testGet2(){
        SqlSession session = MybatisUtil.openSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee e = employeeMapper.get2(1);
        System.out.println(e);
        System.out.println(e.getDept());
        session.close();
    }

    @Test
    public void testList2(){
        SqlSession session = MybatisUtil.openSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Employee> es = employeeMapper.list2();
        for(Employee e : es){
            System.out.println(e);
            System.out.println(e.getDept());
        }

        session.close();
    }

    @Test
    public void testGet3(){
        SqlSession session = MybatisUtil.openSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee e = employeeMapper.get3(1);
        System.out.println(e);
        System.out.println(e.getDept());
        session.close();
    }

    @Test
    public void testList3(){
        SqlSession session = MybatisUtil.openSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Employee> es = employeeMapper.list3();
        for(Employee e : es){
            System.out.println(e);
            System.out.println(e.getDept());
        }

        session.close();
    }

    @Test
    public void testGet4(){
        SqlSession session = MybatisUtil.openSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee e = employeeMapper.get4(1);
        System.out.println(e);
        System.out.println(e.getDept());
        session.close();
    }

    @Test
    public void testList4(){
        SqlSession session = MybatisUtil.openSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Employee> es = employeeMapper.list4();
        for(Employee e : es){
            System.out.println(e);
            System.out.println(e.getDept());
        }

        session.close();
    }

}
