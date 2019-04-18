package test.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class DruidDataSource implements DataSourceFactory {

    DataSource dataSource;

    @Override
    public void setProperties(Properties properties) {
        try{
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }
}
