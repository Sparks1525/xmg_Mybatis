package com.xmg.service;

import com.xmg.domain.User;
import com.xmg.mapper.UserMapper;

import java.util.List;

public class UserServerImpl implements IUserService{

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void add(User u) {
        userMapper.add(u);
    }

    @Override
    public void update(User u) {
        userMapper.update(u);
    }

    @Override
    public User get(long id) {
        return userMapper.get(id);
    }

    @Override
    public void delete(long id) {
        userMapper.delete(id);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
