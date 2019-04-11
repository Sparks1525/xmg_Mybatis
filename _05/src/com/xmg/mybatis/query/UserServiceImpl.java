package com.xmg.mybatis.query;

import com.xmg.mybatis.IUserService;
import com.xmg.mybatis.domain.User;
import com.xmg.mybatis.domain.UserMapper;
import com.xmg.mybatis.util.MybatisUtil;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private UserMapper userMapper;

    public UserServiceImpl(){
        userMapper = MybatisUtil.openSession().getMapper(UserMapper.class);
    }


    public PageResult query(UserQueryObject qo){

        int totalCount = userMapper.queryForCount(qo);

        if(totalCount > 0){
            List<User> list = userMapper.query(qo);
            return new PageResult(totalCount, qo.getPageSize(),
                    qo.getCurrentPage(),list);
        }

        return new PageResult().empty(qo.getPageSize());
    }
}
