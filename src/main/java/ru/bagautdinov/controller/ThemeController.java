package ru.bagautdinov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bagautdinov.form.CommentForm;
import ru.bagautdinov.model.Board;
import ru.bagautdinov.model.Comment;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;
import ru.bagautdinov.repository.BoardRepository;
import ru.bagautdinov.repository.CommentRepository;
import ru.bagautdinov.repository.ThemeRepository;
import ru.bagautdinov.service.CommentService;
import ru.bagautdinov.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/{board_uri}/theme")
public class ThemeController {
    @Autowired
    ThemeRepository themeRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;


    @GetMapping(value = "/{theme_id}")
    public String showTheme(@PathVariable String board_uri,
                            @PathVariable long theme_id, Model model) {
        Theme theme = themeRepository.findById(theme_id);
        Board board =boardRepository.findByLink(board_uri);
        List<Comment> comments = commentRepository.findByTheme(theme);
        model.addAttribute("board", board);
        model.addAttribute("theme", theme);
        model.addAttribute("comments", comments);
        model.addAttribute("comment_form", new CommentForm());

        return "theme_page";
    }

    @PostMapping(value = "/{theme_id}/add_comment")
    public String addComment(@PathVariable long theme_id, Model model,
                             @ModelAttribute("comment_form") @Valid CommentForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/{board_uri}/theme/{theme_id}";
        }
        User user = userService.getAuthenticatedUser();
        Theme theme = themeRepository.findById(theme_id);

        commentService.addNewComment(form, user, theme);

        return "redirect:/{board_uri}/theme/{theme_id}";
    }
}
