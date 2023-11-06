package com.example.proyectobases;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql("classpath:dataset.sql")
class ProyectoBasesApplicationTests {

    @Test
    void contextLoads() {
    }

}
