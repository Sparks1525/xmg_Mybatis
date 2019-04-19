package test.domain;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//     com.xmg.mybatis.domain.UserMapper.add
//     @Insert("insert into user(name,email,age,borndate) values (#{name},#{email},#{age},#{bornDate})")
//     @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    void add(User u);

//     com.xmg.mybatis.domain.UserMapper.update
//     @Update()
    void update(User u);

    void update2(User u);

    void update3(User u);

//     com.xmg.mybatis.domain.UserMapper.delete
//     @Delete()
    void delete(long id);

//     com.xmg.mybatis.domain.UserMapper.get
//     @Select("select id,name,email,age,borndate from user where id = #{id}")
//     @ResultMap("user_mapping")
//    @Results({
//            @Result(id = true, column = "id", property = "id"),
//            @Result(column = "name", property = "name")
//    })
    User get(long id);

//     com.xmg.mybatis.domain.UserMapper.list
    List<User> list();

    List<User> list2(List<Integer> ages);

    List<User> find1(User u);

    List<User> find2(User u);

    List<User> find3(User u);

    User login(Map<String, Object> root);

    User login2(@Param("username") String username, @Param("password") String password);
}
