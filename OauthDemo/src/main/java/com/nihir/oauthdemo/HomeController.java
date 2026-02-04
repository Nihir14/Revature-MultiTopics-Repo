package com.nihir.oauthdemo;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model, OAuth2AuthenticationToken auth) {
        String name = auth.getPrincipal().getAttributes().get("name").toString();
        model.addAttribute("name", name);
        return "home";
    }
}
