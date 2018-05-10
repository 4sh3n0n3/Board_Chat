package ru.bagautdinov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.bagautdinov.form.UserRegistrationForm;
import ru.bagautdinov.model.User;
import ru.bagautdinov.repository.UserRepository;
import ru.bagautdinov.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @RequestMapping(value = "login")
    public String loginPage(Model m) {
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration(Model m) {
        m.addAttribute("userform", new UserRegistrationForm());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registerUser(@ModelAttribute("userform") @Valid UserRegistrationForm form,
                               BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "/registration";
        }
        try {
            userService.saveNewUser(form);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {

            ObjectError mailError = userService.checkEmail(form.getEmail());
            ObjectError nameError = userService.checkUsername(form.getUsername());

            if (mailError != null) {
                result.addError(mailError);
            }
            if (nameError != null) {
                result.addError(nameError);
            }

            return "/registration";
        }
        return "redirect:/home";
    }

    @GetMapping(value = "/users/{username}")
    public String showUser(@PathVariable String  username, Model model) {
        User user = userRepository.findByUsername(username);
        model.addAttribute(user);
        return "userpage";
    }
}
