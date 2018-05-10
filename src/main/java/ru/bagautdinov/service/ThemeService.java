package ru.bagautdinov.service;

import org.springframework.stereotype.Service;
import ru.bagautdinov.model.Board;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;

import java.util.List;

@Service
public interface ThemeService {
    void addNewTheme(User owner, Board board, String name, String content);
}
