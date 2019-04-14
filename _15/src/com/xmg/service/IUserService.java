package com.xmg.service;

import com.xmg.domain.User;

import java.util.List;

public interface IUserService {

    void add(User u);

    void update(User u);

    User get(long id);

    void delete(long id);

    List<User> list();
}
