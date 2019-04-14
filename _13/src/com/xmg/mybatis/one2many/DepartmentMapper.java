package com.xmg.mybatis.one2many;

import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {

    void add(Department d);
    Department get(long id);
    void updateRelation(@Param("empId") Long empId, @Param("deptId") Long deptId);
}
