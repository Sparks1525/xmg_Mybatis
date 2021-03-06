package com.xmg.mybatis.domain;

import com.xmg.mybatis.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

import java.util.Date;
import java.util.List;

public class HelloTest {


    @Test
    public void testSave(){

        User u = new User();
        u.setName("insert");
        u.setAge(18);
        u.setEmail("email");
        u.setBornDate(new Date());
        try{
            //启动框架
            SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("mybatis-config.xml"));
            //通过factory得到SqlSession
            SqlSession session = sf.openSession();

            //找到SQL,保存对象
            session.insert("com.xmg.mybatis.domain.UserMapper.add", u);

            //提交事务
            session.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        try{
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("mybatis-config.xml"));
            SqlSession session = factory.openSession();
            User u = new User();
            u.setId(2L);
            u.setName("update");
            u.setBornDate(new Date());

            session.update("com.xmg.mybatis.domain.UserMapper.update",u);
            session.commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGet(){
        SqlSession session = MybatisUtil.openSession();
        User u = session.selectOne("com.xmg.mybatis.domain.UserMapper.get", 2L);
        System.out.println(u);
    }

    @Test
    public void testDelete(){
        SqlSession session = MybatisUtil.openSession();
        session.delete("com.xmg.mybatis.domain.UserMapper.delete",2L);
        session.commit();
        session.close();
    }

    @Test
    public void testList(){
        SqlSession session = MybatisUtil.openSession();
        List<User> us = session.selectList("com.xmg.mybatis.domain.UserMapper.list");
        System.out.println(us);
    }
}
