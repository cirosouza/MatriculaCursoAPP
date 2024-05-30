package org.javaexercises.matriculacursosapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MatriculaCursosAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatriculaCursosAppApplication.class, args);
    }

}
