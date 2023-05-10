package com.example.creditsystem.data.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DatabaseConfiguration {
    private static final String URL = "jdbc:mysql://localhost:3306/credit_system";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(URL);
        driverManagerDataSource.setDriverClassName(DRIVER);
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate provideJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
