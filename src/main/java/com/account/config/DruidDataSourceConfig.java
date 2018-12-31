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
        basePackages = {DruidDataSourceConfig.MAPPER_PACKAGE},
        sqlSessionFactoryRef = "baseSqlSessionTemplate"
)
@Primary
public class DruidDataSourceConfig extends DataSourceProperties {
    private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

    // MAPPER 的xml存放路径
    protected final static String MAPPER_XML_AREA = "classpath:mapper/base/*.xml";
    // MAPPER.JAVA 存放路径，被@MapperScan扫描的，注入 sqlSession的
    protected final static String MAPPER_PACKAGE = "com.account.dao.base";

    @Value("${spring.datasource.base.url}")
    private String dbUrl;

    @Value("${spring.datasource.base.username}")
    private String username;

    @Value("${spring.datasource.base.password}")
    private String password;

    @Value("${spring.datasource.base.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.base.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.base.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.base.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.base.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.base.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.base.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.base.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.base.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.base.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.base.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.base.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.base.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.base.filters}")
    private String filters;

    @Value("${spring.datasource.base.connectionProperties}")
    private String connectionProperties;

    /**
     * 注入dataSource数据源
     *
     * @return
     */
    @Bean(name = "baseDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.base")
    @Primary
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
    @Bean(name = "baseTransactionManager")
    @Primary
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
    @Bean(name = "baseSqlSessionTemplate")
    @Primary
    public SqlSessionFactory setSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(setDataSource());
        // 设置mapper.xml 扫描路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DruidDataSourceConfig.MAPPER_XML_AREA));
        return bean.getObject();
    }


}
