package ru.bagautdinov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bagautdinov.model.Board;
import ru.bagautdinov.model.User;
import ru.bagautdinov.repository.BoardRepository;
import ru.bagautdinov.service.UserService;

import java.util.List;

@Controller
public class BaseController {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserService userService;

    @GetMapping(value = "/home")
    public String getHomePage(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        model.addAttribute("user", userService.getAuthenticatedUser());
        return "home_page";
    }

    @GetMapping(value = "/")
    public String homePageRedirect(Model model) {
        return getHomePage(model);
    }
}
