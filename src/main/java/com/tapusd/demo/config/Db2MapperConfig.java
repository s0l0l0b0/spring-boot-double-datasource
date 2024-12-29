package com.tapusd.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.tapusd.demo.mapper.db2", sqlSessionFactoryRef = "db2SqlSessionFactory")
public class Db2MapperConfig {
    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "secondary.datasource")
    public DataSource dataSource() {
        return (DataSource) new org.springframework.beans.factory.xml.XmlBeanFactory(new ClassPathResource("config/secondary-datasource.xml")).getBean("db2DataSource");
    }
    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setConfigLocation(new ClassPathResource("config/mybatis-config.xml"));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db2/*.xml"));
        return sessionFactory.getObject(); }

}
