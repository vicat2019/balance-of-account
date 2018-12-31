package com.account.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: Administrator
 * @Date: 2018 2018/7/22 19 39
 **/
@Configuration
@MapperScan(
        // 此处的mapper 可以有多个
        basePackages = {DruidDataSourceSeondConfig.MAPPER_PACKAGE},
        sqlSessionFactoryRef = "otherSqlSessionTemplate"
)
public class DruidDataSourceSeondConfig extends DataSourceProperties {
    private Logger logger = LoggerFactory.getLogger(DruidDataSourceSeondConfig.class);

    // MAPPER 的xml存放路径
    protected final static String MAPPER_XML_AREA = "classpath:mapper/other/*.xml";
    // MAPPER.JAVA 存放路径，被@MapperScan扫描的，注入 sqlSession的
    protected final static String MAPPER_PACKAGE = "com.account.dao.other";

    @Value("${spring.datasource.other.url}")
    private String dbUrl;

    @Value("${spring.datasource.other.username}")
    private String username;

    @Value("${spring.datasource.other.password}")
    private String password;

    @Value("${spring.datasource.other.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.other.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.other.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.other.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.other.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.other.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.other.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.other.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.other.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.other.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.other.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.other.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.other.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.other.filters}")
    private String filters;

    @Value("${spring.datasource.other.connectionProperties}")
    private String connectionProperties;

    /**
     * 注入dataSource数据源
     *
     * @return
     */
    @Bean(name = "otherDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.other")
    public DataSource setDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(connectionProperties);
        return datasource;
    }

    /**
     * 注入 事务，在 serviceImpl 的时候使用
     *
     * @return
     */
    @Bean(name = "otherTransactionManager")
    public DataSourceTransactionManager setTransactionManager() {
        // 传入 dataSource
        return new DataSourceTransactionManager(setDataSource());
    }

    /**
     * 注入 sqlSession
     *
     * @return
     * @throws Exception
     */
    @Bean(name = "otherSqlSessionTemplate")
    public SqlSessionFactory setSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(setDataSource());
        // 设置MAPPER.xml 扫描路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DruidDataSourceSeondConfig.MAPPER_XML_AREA));
        return bean.getObject();
    }


}
