package test.many2many;

import java.util.List;

public interface StudentMapper {

    void add(Student s);

    int insertAndgetkey(Student t);

    Student get(long id);

    List<Student> list();
}
