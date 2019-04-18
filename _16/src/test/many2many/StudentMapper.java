package test.many2many;

import java.util.List;

public interface StudentMapper {

    void add(Student s);

    // 这里返回值要嘛void要嘛Integer,不能为Long,因为这不是返回id值,返回的id值在对象id字段里
    Integer insertAndgetkey(Student t);

    Student get(long id);

    List<Student> list();
}
