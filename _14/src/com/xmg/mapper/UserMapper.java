package com.xmg.mapper;

import com.xmg.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    void add(User u);

    void update(User u);

    User get(long id);

    void delete(long id);

    List<User> list();

}
