package org.practica.springbootspringsecurity.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class TestAuthController {

    @GetMapping("/hola")
    public String index() {
        return "Hola";
    }

    @GetMapping("/hola2")
    public String index2() {
        return "Hola2";
    }

    @GetMapping("/hola3")
    public String index3() {
        return "Hola3";
    }
}
