package com.msa.study.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping(value = "/")
    public String index(Model model) {
        System.out.println("test");
        return "index";
    }
}