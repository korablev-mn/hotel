package io.khasang.hotel.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class DeleteTable {
    private JdbcTemplate jdbcTemplate;

    public DeleteTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DeleteTable() {
    }

    public String deleteTableStatus() {
        jdbcTemplate.execute("DELETE FROM PUBLIC.films WHERE time > 90 AND time < 92");
        return "table deleted ok";
    }
}
