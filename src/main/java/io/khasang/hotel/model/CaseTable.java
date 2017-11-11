package io.khasang.hotel.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CaseTable {
    private JdbcTemplate jdbcTemplate;

    public CaseTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CaseTable() {
    }

    public String caseTableStatus() {
        jdbcTemplate.execute("SELECT name, \n" +
                " CASE WHEN films.name = 'Пэппи' THEN \n" +
                " 'Терминатор 4' \n" +
                "ELSE 'Пэппи - 2' \n" +
                "END  AS newname FROM PUBLIC.films");
        return "table case ok";
    }
}
