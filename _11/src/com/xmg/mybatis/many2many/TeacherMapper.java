package com.xmg.mybatis.many2many;


import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

    void add(Teacher t);
    Teacher get(long id);

    void resovleRelation(@Param("teaId")Long teaId,@Param("stuId")Long stuId);
}
