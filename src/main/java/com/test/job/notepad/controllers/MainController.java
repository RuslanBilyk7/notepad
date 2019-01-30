package com.test.job.notepad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("/")
    public String start(Model model) {
        return "login";
    }

    @RequestMapping("/registration")
    public String loginPage(Model model) {
        return "registration";
    }
}
