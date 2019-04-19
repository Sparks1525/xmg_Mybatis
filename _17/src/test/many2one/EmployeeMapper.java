package test.many2one;

import java.util.List;

public interface EmployeeMapper {
    void add(Employee e);

    Employee get(long id);

    List<Employee> list();

    Employee get2(long id);

    List<Employee> list2();

    Employee get3(long id);

    List<Employee> list3();

    Employee get4(long id);

    List<Employee> list4();

}
