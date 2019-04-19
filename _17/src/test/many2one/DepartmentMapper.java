package test.many2one;

import java.util.List;

public interface DepartmentMapper {

    void add(Department d);
    Department get(long id);
    List<Department> list();

}
