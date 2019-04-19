package test.one2many;

import java.util.List;

public interface DepartmentMapper {

    void add(Department d);

    Department get(long id);
    List<Department> list();

    Department get2(long id);
    List<Department> list2();

}
