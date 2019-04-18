package test.many2many;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    void add(Teacher t);

    int insertAndgetkey(Teacher t);

    void resovleRelation(@Param("teaId") Long teaId, @Param("stuId") Long stuId);

    Teacher get(long id);

    List<Teacher> list();

    Teacher get2(long id);

    List<Teacher> list2();


}
