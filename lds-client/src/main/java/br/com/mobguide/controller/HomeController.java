package br.com.mobguide.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/teste")
    public String getHomePage() {
        return "home";
    }

}
