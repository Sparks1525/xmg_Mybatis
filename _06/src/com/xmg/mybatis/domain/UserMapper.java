package com.xmg.mybatis.domain;

import java.util.List;

public interface UserMapper {

    // com.xmg.mybatis.domain.UserMapper.add
    void add(User u);

    // com.xmg.mybatis.domain.UserMapper.update
    void update(User u);

    // com.xmg.mybatis.domain.UserMapper.get
    User get(long id);

    // com.xmg.mybatis.domain.UserMapper.delete
    void delete(long id);

    // com.xmg.mybatis.domain.UserMapper.list
    List<User> list();

    List<User> list2(List<Integer> ages);
}
