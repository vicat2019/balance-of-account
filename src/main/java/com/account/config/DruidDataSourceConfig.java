package com.account.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Log4jFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Administrator
 * @Date: 2018 2018/7/22 19 39
 **/
@Configuration
@Primary
public class DruidDataSourceConfig extends DataSourceProperties {
    private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

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

    @Bean
    public DataSource dataSource() {
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

        List<Filter> list = new ArrayList<>();
        list.add(statFilter());
        list.add(log4jFilter());
        datasource.setProxyFilters(list);

        return datasource;
    }

    @Bean("log-filter")
    public Log4jFilter log4jFilter() {
        Log4jFilter log4jFilter = new Log4jFilter();
        log4jFilter.setStatementExecutableSqlLogEnable(true);

        return log4jFilter;
    }


    @Bean("stat-filter")
    public StatFilter statFilter() {
        StatFilter statFilter = new StatFilter();

        statFilter.setMergeSql(true);
        statFilter.setSlowSqlMillis(1000);
        statFilter.setLogSlowSql(true);

        return statFilter;
    }

/*    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "dataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplateOne(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }*/





























}
