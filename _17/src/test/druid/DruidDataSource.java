package test.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 *  实现DataSourceFactory接口，并实现setProperties和getEDataSource方法。
 */
public class DruidDataSource implements DataSourceFactory {

    DataSource dataSource;

    //在配置文件中配置的dataSource里面的property元素即会被解析为这里的Properties对象。
    //这个properties可以用来配置数据连接池。
    @Override
    public void setProperties(Properties properties) {
        try{
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //Mybatis即是通过该方法获得数据库连接的。
    @Override
    public DataSource getDataSource() {
        return dataSource;
    }
}
