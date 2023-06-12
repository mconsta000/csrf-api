package com.skunkworks.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(UiApplication.class);

    @GetMapping("/user")
    public Principal user(Principal user) {
        log.debug("Returning user {}", user);

        return user;
    }

    public Map<String, Object> home() {
        log.debug("home()");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @GetMapping("/resource")
    public Map<String, Object> get() {
        log.debug("GET /resource");

        return home();
    }

    @PostMapping("/resource")
    public Map<String, Object> post() {
        log.debug("POST /resource");

        return home();
    }

    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }
}
