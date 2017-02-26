package spittr.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by yudequan on 23/02/2017.
 */
@Configuration
public class SpittrConfig
{
    @Bean
    public DataSource dataSource()
    {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUsername("scott");
        ds.setPassword("tiger");
        ds.setUrl("jdbc:oracle:thin:@106.14.16.212:1521:orcl");
        ds.setInitialSize(5);
        ds.setMaxIdle(10);
        return ds;
    }

    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
}
