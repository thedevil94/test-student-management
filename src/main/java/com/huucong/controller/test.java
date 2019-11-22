package com.huucong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {
    @GetMapping("/demo")
    public String test(){
        return "test";
    }
}
