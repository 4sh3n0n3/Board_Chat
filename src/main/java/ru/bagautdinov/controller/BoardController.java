package ru.bagautdinov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.bagautdinov.model.Board;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.repository.BoardRepository;
import ru.bagautdinov.repository.ThemeRepository;
import ru.bagautdinov.service.UserService;

import java.util.List;


@Controller
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ThemeRepository themeRepository;

    @GetMapping(value = "/{board_uri}")
    public String getBoardMainPage(@PathVariable String board_uri, Model model) {
        Board board = boardRepository.findByLink(board_uri);
        List<Theme> themeList = themeRepository.findByBoard(board);
        model.addAttribute("themes", themeList);
        model.addAttribute("board", board);
        return "board_page";
    }
}
