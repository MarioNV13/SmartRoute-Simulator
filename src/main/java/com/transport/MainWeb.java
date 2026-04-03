package com.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This will turn on the web engine
public class MainWeb {
    public static void main(String[] args) {
        // This will turn on the server on 8080 port
        SpringApplication.run(MainWeb.class, args);
    }
}
// INTRODUCE THIS LINK IN YOUR BROWSER: http://localhost:8080/index.html