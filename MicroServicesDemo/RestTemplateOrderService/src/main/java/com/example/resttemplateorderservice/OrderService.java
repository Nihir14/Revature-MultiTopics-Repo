package com.example.resttemplateorderservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    public User getUserFromUserService(Long userId) {
        String url = "http://localhost:8081/users/" + userId;
        return restTemplate.getForObject(url, User.class);
    }
}
