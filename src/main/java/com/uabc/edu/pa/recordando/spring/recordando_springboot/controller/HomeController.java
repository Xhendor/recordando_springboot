package com.uabc.edu.pa.recordando.spring.recordando_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {


    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("name",
                "Soy la variable enviada desde el controlador");
        return "dashboard/index";
    }
}
