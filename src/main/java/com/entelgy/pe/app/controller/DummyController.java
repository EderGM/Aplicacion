package com.entelgy.pe.app.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.entelgy.pe.app.model.ObjetoBase;
import com.entelgy.pe.app.model.response.DummyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/v1/")
public class DummyController {

    private static final String template = "Entelgeer, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("nombre")
    public ObjetoBase saludo(@RequestParam(value = "name", defaultValue = "anonimo") String name) {
        return new DummyResponse(String.valueOf(counter.incrementAndGet()), String.format(template, name));
    }

 @GetMapping("nombreapellido")
    public ObjetoBase saludo(@RequestParam(value = "name", defaultValue = "anonimo") String name,@RequestParam(value = "apellido", defaultValue = "anonimo") String apellido) {
        return new DummyResponse(String.valueOf(counter.incrementAndGet()), String.format(template, name+" " +apellido));
    }


}
