package test.many2many;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    void add(Teacher t);

    // 这里返回值要嘛void要嘛Integer,不能为Long,因为这不是返回id值,返回的id值在对象id字段里
    Integer insertAndgetkey(Teacher t);

    void resovleRelation(@Param("teaId") Long teaId, @Param("stuId") Long stuId);

    Teacher get(long id);

    List<Teacher> list();

    Teacher get2(long id);

    List<Teacher> list2();


}
