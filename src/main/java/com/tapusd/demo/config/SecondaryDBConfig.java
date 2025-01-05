package com.tapusd.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class SecondaryDBConfig {

    @Value("${secondary.datasource.url}")
    private String url;

    @Value("${secondary.datasource.username}")
    private String username;

    @Value("${secondary.datasource.password}")
    private String password;

    @Value("${secondary.datasource.driver-class-name}")
    private String driverClassName;

    @Bean(name = "secondaryDataSource")
    public DataSource secondaryDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setMinimumIdle(5);
        hikariConfig.setMaximumPoolSize(20);  // Set the max pool size, you can adjust based on your needs
        hikariConfig.setPoolName("SecondaryHikariPool");

        // Additional HikariCP properties
        hikariConfig.setConnectionTimeout(30000);  // Connection timeout in milliseconds
        hikariConfig.setIdleTimeout(600000);  // Idle timeout in milliseconds (10 minutes)
        hikariConfig.setMaxLifetime(1800000);  // Max lifetime of a connection (30 minutes)

        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate() {
        return new JdbcTemplate(secondaryDataSource());
    }

    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager secondaryTransactionManager() {
        return new JdbcTransactionManager(secondaryDataSource());
    }
}
