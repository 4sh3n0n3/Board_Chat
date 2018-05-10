package ru.bagautdinov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bagautdinov.model.BanList;
import ru.bagautdinov.model.User;
import ru.bagautdinov.repository.BanListRepository;
import ru.bagautdinov.repository.UserRepository;
import ru.bagautdinov.service.BanListService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BanListRepository banListRepository;

    @Autowired
    BanListService banListService;

    @GetMapping(value = "/all_users")
    public String admin_main(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute(userList);
        return "admin_main";
    }

    @PostMapping(value = "/ban_user/{username}")
    public String banUser(Model model, @PathVariable String username) {
        User user = userRepository.findByUsername(username);
        BanList ban = banListRepository.findByBanned(user);
        if (ban == null) {
            banListService.addBanVithoutReason(user);
        } else {
            banListService.razban(user);
        }
        return "redirect:/admin/all_users";
    }
}
