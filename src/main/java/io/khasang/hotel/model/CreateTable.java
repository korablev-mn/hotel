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
        jdbcTemplate.execute("CREATE TABLE public.films \n" +
                "(\n" +
                "  id integer NOT NULL,\n" +
                "  name character varying(255),\n" +
                "  size integer NOT NULL ,\n" +
                "  description character varying(255),\n" +
                "  time integer,\n" +
                "  CONSTRAINT films_pkey PRIMARY KEY (id)\n" +
                ")");
        return "table created";
    }
}
