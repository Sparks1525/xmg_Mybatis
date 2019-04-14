package com.xmg.mybatis.many2one;

public interface DepartmentMapper {

    void add(Department d);
    Department get(long id);
}
