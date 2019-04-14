package com.xmg.mybatis.many2one;

import java.util.List;

public interface EmployeeMapper {

    void add(Employee e);

    Employee get(long id);

    List<Employee> list();

    List<Employee> list2();

    List<Employee> autoCompateList();
}
