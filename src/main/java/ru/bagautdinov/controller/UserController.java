package ru.bagautdinov.controller;


import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.bagautdinov.form.UserRegistrationForm;
import ru.bagautdinov.repository.UserRepository;
import ru.bagautdinov.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping(value = "/registration")
    public String registration(Model m) {
        m.addAttribute("userform", new UserRegistrationForm());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registerUser(@ModelAttribute("userform") @Valid UserRegistrationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/registration";
        }
        try {
            userService.saveNewUser(form);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {

            ObjectError mailError = userService.checkEmail(form.getEmail());
            ObjectError nameError = userService.checkUsername(form.getUsername());

            result.addError(mailError);
            result.addError(nameError);

            return "/registration";
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        return "index";
    }
}
