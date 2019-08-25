package com.byon.gorilla.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/health")
    @ResponseBody
    public String getHealth(){
        return "up";
    }

}
