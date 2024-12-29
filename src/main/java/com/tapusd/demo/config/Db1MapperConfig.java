package com.tapusd.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.tapusd.demo.mapper.db1",sqlSessionFactoryRef = "db1SqlSessionFactory")
@ImportResource(locations = "classpath:config/primary-datasource.xml")
public class Db1MapperConfig {
//    @Primary
////    @Bean(name = "db1DataSource")
//    @ConfigurationProperties(prefix = "primary.datasource")
//    public DataSource dataSource() {
//        return (DataSource) new org.springframework.beans.factory.xml.XmlBeanFactory(new ClassPathResource("config/primary-datasource.xml")).getBean("db1DataSource");
//    }

    @Primary
    @Bean(name = "db1SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setConfigLocation(new ClassPathResource("config/mybatis-config.xml"));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db1/*.xml"));
        return sessionFactory.getObject(); }
}
