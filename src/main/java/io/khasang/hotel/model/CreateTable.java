package io.khasang.hotel.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateTable() {
    }

    public String createTableStatus() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS films");
        jdbcTemplate.execute("CREATE TABLE PUBLIC.films \n" +
                "(\n" +
                "id INTEGER  NOT NULL ,) \n" +
                "name CHARACTER  VARYING (255) NOT NULL, \n" +
                "CONSTRAINT firstkey PRIMARY KEY (id) \n" +
                ");");
        return "table created";
    }
}
