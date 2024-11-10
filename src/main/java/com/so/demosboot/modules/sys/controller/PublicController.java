package com.so.demosboot.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {

    @RequestMapping("index")
    public String index(){
        return "sys/index";
    }

    @GetMapping("login")
    public String table(){
        return "sys/login";
    }

    @RequestMapping("list")
    public String form(){
        return "list";
    }

    @RequestMapping("text")
    public String text(){
        return "index";
    }

    @RequestMapping("form")
    public String basicForm(){
        return "form_basic";
    }
}
