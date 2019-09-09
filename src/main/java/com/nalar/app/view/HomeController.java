package com.nalar.app.view;

/*
    Copyright (c) 2019 Neftali Alarcón
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String index() {
        return "index";
    }

}
