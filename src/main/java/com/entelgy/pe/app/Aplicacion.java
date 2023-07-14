package com.entelgy.pe.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aplicacion {

    public static void main(String[] args) {
        System.out.println("Arrancando mi aplicación");
        SpringApplication.run(Aplicacion.class, args);
    }
}