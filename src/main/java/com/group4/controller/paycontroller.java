package com.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class paycontroller {
    @GetMapping("/payment")
    public String payment() {
        return "payment";
    }
}
