package test.cache;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import test.util.MybatisUtil;

import java.util.List;

public class CacheTest {

    @Test
    public void testInsert() {
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = new User();
        mapper.add(u);
        session.commit();
    }

    @Test
    public void testGet() {
        SqlSession session = MybatisUtil.openSession();

        System.out.println(session.getConfiguration().getCacheNames());
        Cache cache = session.getConfiguration().getCache(
                "com.xmg.mybatis.cache.mapper.UserMapper");
        cache.clear();
        System.out.println(cache);


        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = mapper.get(1L);
        session.close();


        try{
            Thread.sleep(6000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        session = MybatisUtil.openSession();
        mapper = session.getMapper(UserMapper.class);
        mapper.get(1L);
        session.close();

    }


    @Test
    public void testList(){
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> us = mapper.list();
        session.close();

        session = MybatisUtil.openSession();
        mapper = session.getMapper(UserMapper.class);
        User u = new User();
        mapper.add(u);
        session.commit();
        session.close();

        session = MybatisUtil.openSession();
        mapper = session.getMapper(UserMapper.class);
        us = mapper.list();
        System.out.println(us);
        session.close();
    }

    public void testLogin() {
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = mapper.login2("update", "3");
        System.out.println(u);
        session.commit();
    }


}
