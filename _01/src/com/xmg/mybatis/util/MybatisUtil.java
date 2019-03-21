package com.xmg.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MybatisUtil {
    private static MybatisUtil instance = new MybatisUtil();
    private SqlSessionFactory factory;

    private MybatisUtil(){
        try{
            //启动框架
            factory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSession openSession(){
        return instance.factory.openSession();
    }
}
