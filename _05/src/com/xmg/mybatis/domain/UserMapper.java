package com.xmg.mybatis.domain;

import com.xmg.mybatis.query.UserQueryObject;

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

    int queryForCount(UserQueryObject qo);

    List<User> query(UserQueryObject qo);

}
