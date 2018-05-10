package ru.bagautdinov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bagautdinov.form.ThemeForm;
import ru.bagautdinov.model.Board;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;
import ru.bagautdinov.repository.BoardRepository;
import ru.bagautdinov.repository.ThemeRepository;
import ru.bagautdinov.service.ThemeService;
import ru.bagautdinov.service.UserService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ThemeRepository themeRepository;

    @Autowired
    ThemeService themeService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/{board_uri}")
    public String getBoardMainPage(@PathVariable String board_uri, Model model) {
        Board board = boardRepository.findByLink(board_uri);
        List<Theme> themeList = themeRepository.findByBoard(board);
        model.addAttribute("themes", themeList);
        model.addAttribute("board", board);
        model.addAttribute("theme_form", new ThemeForm());
        return "board_page";
    }

    @PostMapping(value = "/{board_uri}/create_theme")
    public String createTheme(@PathVariable String board_uri, Model model,
                              @ModelAttribute("theme_form") @Valid ThemeForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/{board_uri}";
        }

        User user = userService.getAuthenticatedUser();
        Board board = boardRepository.findByLink(board_uri);

        themeService.addNewTheme(user, board, form);

        return "redirect:/{board_uri}";
    }
}
