package ru.bagautdinov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

    @GetMapping(value = "/home")
    public String getHomePage() {
        return "index";
    }

    @GetMapping(value = "/")
    public String homePageRedirect() {
        return getHomePage();
    }
}
