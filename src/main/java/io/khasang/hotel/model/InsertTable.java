package io.khasang.hotel.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class InsertTable {
    private JdbcTemplate jdbcTemplate;

    public InsertTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public InsertTable() {
    }

    public String insertTableStatus() {
        jdbcTemplate.execute("INSERT INTO Public.films (id,name, size, description, time ) \n" +
                "VALUES (24,'Терминатор', 1650, 'фильм апокалипсис', 95)");
        jdbcTemplate.execute("INSERT INTO Public.films (id,name, size, description, time ) \n" +
                "VALUES (26,'Терминатор2', 1750, 'фильм апокалипсис 2', 85)");
        jdbcTemplate.execute("INSERT INTO Public.films (id,name, size, description, time ) \n" +
                "VALUES (27,'Терминатор3', 1610, 'комедия', 91)");
        jdbcTemplate.execute("INSERT INTO Public.films (id,name, size, description, time ) \n" +
                "VALUES (22,'Пэппи', 1150, 'мультфильм', 90)");
        return "table insert ok";
    }
}
