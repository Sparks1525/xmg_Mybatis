package test.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import test.one2many.Department;
import test.one2many.DepartmentMapper;
import test.one2many.Employee;
import test.one2many.EmployeeMapper;
import test.util.MybatisUtil;

import java.util.List;

public class One2ManyTest {

    DepartmentMapper departmentMapper;
    EmployeeMapper employeeMapper;


    @Test
    public void testSave(){
        SqlSession session = MybatisUtil.openSession();
        departmentMapper = session.getMapper(DepartmentMapper.class);
        employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee e1 = new Employee();
        e1.setName("e1");


        Employee e2 = new Employee();
        e2.setName("e2");

        Department d1 = new Department();
        d1.setName("d1");
        d1.getEmps().add(e1);

        Department d2 = new Department();
        d2.setName("d2");
        d2.getEmps().add(e2);

        employeeMapper.add(e1);
        employeeMapper.add(e2);

        departmentMapper.add(d1);
        departmentMapper.add(d2);

        session.commit();
        session.close();
    }

    @Test
    public void testGet(){
        SqlSession session = MybatisUtil.openSession();
        departmentMapper = session.getMapper(DepartmentMapper.class);

        Department d = departmentMapper.get(1);

        System.out.println(d);

        List<Employee> es = d.getEmps();
        for(Employee e : es){
            System.out.println(e);
        }

        session.close();
    }

    @Test
    public void testList(){
        SqlSession session = MybatisUtil.openSession();
        departmentMapper = session.getMapper(DepartmentMapper.class);

        List<Department> ds = departmentMapper.list();

        for(Department d: ds){
            System.out.println(d);
            List<Employee> es = d.getEmps();
            for(Employee e : es){
                System.out.println(e);
            }
        }
        session.close();
    }

    @Test
    public void testGet2(){
        SqlSession session = MybatisUtil.openSession();
        departmentMapper = session.getMapper(DepartmentMapper.class);

        Department d = departmentMapper.get2(1);

        System.out.println(d);

        List<Employee> es = d.getEmps();
        for(Employee e : es){
            System.out.println(e);
        }

        session.close();
    }

    @Test
    public void testList2(){
        SqlSession session = MybatisUtil.openSession();
        departmentMapper = session.getMapper(DepartmentMapper.class);

        List<Department> ds = departmentMapper.list2();

        for(Department d: ds){
            System.out.println(d);
            List<Employee> es = d.getEmps();
            for(Employee e : es){
                System.out.println(e);
            }
        }
        session.close();
    }


}
