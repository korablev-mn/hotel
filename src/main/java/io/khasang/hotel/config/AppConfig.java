package io.khasang.hotel.config;

import io.khasang.hotel.dao.CatDao;
import io.khasang.hotel.dao.impl.CatDaoImpl;
import io.khasang.hotel.entity.Cat;
import io.khasang.hotel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
@PropertySource(value = "classpath:util.properties")
@PropertySource(value = "classpath:auth.properties")
public class AppConfig {
    @Bean
    public Message message() {
        return new Message("Jack");
    }

    @Autowired
    private Environment environment;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.postgresql.driver"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.postgresql.name"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.postgresql.password"));
        return dataSource;
    }
    @Bean
    public UserDetailsService userDetailsService(){
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource());
        jdbcDao.setUsersByUsernameQuery(environment.getRequiredProperty("usersByQuery"));
        jdbcDao.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery"));
        return jdbcDao;
    }
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    @Bean
    public CreateTable createTable() {
        return new CreateTable(jdbcTemplate());
    }
    @Bean
    public SelectTable selectTable() {
        return new SelectTable(jdbcTemplate());
    }
    @Bean
    public InsertTable insertTable() {
        return new InsertTable(jdbcTemplate());
    }
    @Bean
    public UpdateTable updateTable() {
        return new UpdateTable(jdbcTemplate());
    }
    @Bean
    public DeleteTable deleteTable() {
        return new DeleteTable(jdbcTemplate());
    }
    @Bean
    public JoinTable joinTable() {
        return new JoinTable(jdbcTemplate());
    }
    @Bean
    public CaseTable caseTable() {
        return new CaseTable(jdbcTemplate());
    }
    @Bean
    public CatDao catDao(){
        return new CatDaoImpl(Cat.class);
    }
}
