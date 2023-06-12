package com.skunkworks.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
@RequestMapping("api")
public class UiApplication {

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @PostMapping("/resource")
    public Map<String, Object> post() {
        return home();
    }

    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }
}
