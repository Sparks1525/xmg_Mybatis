package test.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtil {
    private static MybatisUtil instance = new MybatisUtil();
    private SqlSessionFactory factory;

    private MybatisUtil() {
        try {
            //启动框架
            /**
             * mybatis-config.xml没有配置以下标签,则需要在获得session时,手动引进properties
             * <properties resource="db.properties"/>
             *
             */
//            Properties props = new Properties();
//            props.load(Resources.getResourceAsStream("db.properties"));
//            factory = new SqlSessionFactoryBuilder().build(
//                    Resources.getResourceAsStream("mybatis-config.xml"), props);

            factory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("mybatis-cfg.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        return instance.factory.openSession();
    }
}
