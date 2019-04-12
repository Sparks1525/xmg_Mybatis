package com.xmg.mybatis.domain;

import org.apache.ibatis.annotations.*;
import java.util.List;

public interface UserMapper {

    // com.xmg.mybatis.domain.UserMapper.add
    @Insert("insert into user(name,email,age,borndate) values (#{name},#{email},#{age},#{bornDate})")
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    void add(User u);

    // com.xmg.mybatis.domain.UserMapper.update
    // @Update()
    void update(User u);

    // com.xmg.mybatis.domain.UserMapper.get
    @Select("select id,name,email,age,borndate from user where id = #{id}")
    // @ResultMap("user_mapping")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name")
    })
    User get(long id);

    // com.xmg.mybatis.domain.UserMapper.delete
    // @Delete()
    void delete(long id);

    // com.xmg.mybatis.domain.UserMapper.list
    List<User> list();

    List<User> list2(List<Integer> ages);
}
