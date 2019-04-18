package test.many2many;

import java.util.List;

public interface StudentMapper {

    void add(Student s);

    Student get(long id);

    List<Student> list();
}
