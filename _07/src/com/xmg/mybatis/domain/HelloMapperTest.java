package com.xmg.mybatis.domain;

import com.xmg.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class HelloMapperTest {


    @Test
    public void testSave() {

        User u = new User();
        u.setName("insert");
        u.setAge(18);
        u.setEmail("email");
        u.setBornDate(new Date());
        SqlSession session = null;
        try {
            // 通过factory得到SqlSession();
            session = MybatisUtil.openSession();

            // 找到Mapper,保存对象
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.add(u);

            // 提交事务
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testUpdate() {
        User u = new User();
        u.setId(2L);
        u.setName("update");
        u.setBornDate(new Date());
        SqlSession session = null;
        try {
            session = MybatisUtil.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.update(u);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testGet() {
        SqlSession session = MybatisUtil.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = mapper.get(3L);
        System.out.println(u);
    }

    @Test
    public void testDelete() {
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.delete(3L);
        session.commit();
        session.close();
    }

    @Test
    public void testList() {
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> us = mapper.list();
        System.out.println(us);
    }


    @Test
    public void testList2() {
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> us = mapper.list2(Arrays.asList(18,123));
        System.out.println(us);
    }


    @Test
    public void testLogin(){
        Map<String,Object> root = new HashMap<>();
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        root.put("username","update");
        root.put("password","3");
        User u = mapper.login(root);
        System.out.println(u);
    }

    @Test
    public void testLogin2(){
        Map<String,Object> root = new HashMap<>();
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = mapper.login2("update","3");
        System.out.println(u);
    }
}
