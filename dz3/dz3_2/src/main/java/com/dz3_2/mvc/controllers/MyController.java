package com.dz3_2.mvc.controllers;

import com.dz3_2.mvc.models.ModelCurrencyEx;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/task4")
public class MyController {

    @GetMapping("/")
    public String takeRoot() {
        return "root";
    }

    @GetMapping("/uuid")
    @ResponseBody
    public UUID getUUID() {
        return UUID.randomUUID();
    }

    @GetMapping("/exchange")
    @ResponseBody
    public ModelCurrencyEx getFixRate() {
        return new ModelCurrencyEx("UAH","EUR",49.1009);
    }

    @GetMapping("/exchange/{currency}")
    @ResponseBody
    public Map<String,Double> getDynamicRate(@PathVariable String currency) {
        Map<String,Double> map = new HashMap<>();
        map.put(currency,55.507);
        return map;
    }
}
