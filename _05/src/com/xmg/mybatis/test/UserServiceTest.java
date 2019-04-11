package com.xmg.mybatis.test;

import com.xmg.mybatis.IUserService;
import com.xmg.mybatis.query.PageResult;
import com.xmg.mybatis.query.UserQueryObject;
import com.xmg.mybatis.query.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    @Test
    public void testPage(){
        IUserService service = new UserServiceImpl();
        UserQueryObject qo = new UserQueryObject();
        qo.setCurrentPage(1);
        qo.setPageSize(3);

        qo.setBeginAge(17);
        qo.setEndAge(22);

        PageResult result = ((UserServiceImpl) service).query(qo);
        System.out.println(result.getResult());
    }
}
