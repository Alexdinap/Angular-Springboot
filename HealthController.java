package com.sintialab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private static final Logger logger = LoggerFactory.getLogger(HealthController.class);
    private final JdbcTemplate jdbcTemplate;

    public HealthController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping({"", "/"})
    public String home() {
        return "MusicBox backend is running";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/health/db")
    public String databaseHealth() {
        try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            logger.info("DB CONNECTED - SELECT 1 returned {}", result);
            return "Database connected";
        } catch (DataAccessException exception) {
            logger.error("DB CONNECTION FAILED", exception);
            return "Database connection failed: " + exception.getMostSpecificCause().getMessage();
        }
    }
}
