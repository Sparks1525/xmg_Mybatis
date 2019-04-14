package com.xmg.mybatis.many2one;

public interface EmployeeMapper {

    void add(Employee e);
    Employee get(long id);
}
