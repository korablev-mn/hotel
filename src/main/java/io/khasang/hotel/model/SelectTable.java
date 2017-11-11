package io.khasang.hotel.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class SelectTable {
    private JdbcTemplate jdbcTemplate;

    public SelectTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SelectTable() {
    }

    public String selectTableStatus() {
        jdbcTemplate.execute("SELECT * FROM public.cats");
        jdbcTemplate.execute("SELECT films.name FROM public.films where films.id in(SELECT id FROM cats WHERE cats.id = films.id)");
        return "table select ok";
    }
}
