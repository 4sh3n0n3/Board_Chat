package ru.bagautdinov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping(value = "/home")
    public String getHomePage() {
        return "home_page";
    }

    @GetMapping(value = "/")
    public String homePageRedirect() {
        return getHomePage();
    }
}
