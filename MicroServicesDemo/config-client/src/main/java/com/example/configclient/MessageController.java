package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    // This value comes from the Git repo via Config Server
    @Value("${custom.message:Default Message}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return "Message from Server: " + message;
    }
}