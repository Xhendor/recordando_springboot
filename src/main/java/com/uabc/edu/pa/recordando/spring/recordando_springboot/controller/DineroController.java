package com.uabc.edu.pa.recordando.spring.recordando_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

@Controller
public class DineroController {

    @GetMapping(value = "/currency")
    public String exchange(
            @RequestParam(value = "amount", required = false) String amount,
            @RequestParam(value = "amountList", required = false) List amountList,
            Locale locale) {

        return "dinero/mostrarDinero";
    }



}
