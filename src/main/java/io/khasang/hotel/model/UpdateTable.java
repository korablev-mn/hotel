package io.khasang.hotel.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateTable {
    private JdbcTemplate jdbcTemplate;

    public UpdateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UpdateTable() {
    }

    public String updateTableStatus() {
        jdbcTemplate.execute("UPDATE films \n" +
                "SET size = size + 200 \n" +
                "WHERE time < 91 "
        );
        return "table update ok";
    }
}
