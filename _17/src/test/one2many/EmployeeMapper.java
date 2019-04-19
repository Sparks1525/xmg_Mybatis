package test.one2many;

import java.util.List;

public interface EmployeeMapper {

    void add(Employee e);

    Employee get(long id);

    List<Employee> list();

}
