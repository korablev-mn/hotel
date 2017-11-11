package io.khasang.hotel.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class JoinTable {
    private JdbcTemplate jdbcTemplate;

    public JoinTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JoinTable() {
    }

    public String joinTableStatus() {
        jdbcTemplate.execute("SELECT * FROM PUBLIC.films \n" +
        "INNER JOIN PUBLIC.cats ON films.id = cats.id");
        return "table created";
    }
}
