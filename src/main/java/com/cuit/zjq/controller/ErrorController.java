package com.cuit.zjq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ErrorController {

    @GetMapping("/404")
    public String notFound() {
        return "404";
    }

    @GetMapping("/403")
    public String forbidden() {
        return "403";
    }
}
