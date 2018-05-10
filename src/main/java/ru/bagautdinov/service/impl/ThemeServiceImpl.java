package ru.bagautdinov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bagautdinov.model.Board;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;
import ru.bagautdinov.repository.ThemeRepository;
import ru.bagautdinov.service.ThemeService;

import java.util.Date;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    ThemeRepository themeRepository;

    @Override
    public void addNewTheme(User owner, Board board, String name, String content) {
        Theme theme = new Theme();
        theme.setBoard(board);
        theme.setContent(content);
        theme.setName(name);
        theme.setOwner(owner);
        theme.setCreatedAt(new Date());
        themeRepository.save(theme);
    }
}
