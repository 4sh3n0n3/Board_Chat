package ru.bagautdinov.service;

import org.springframework.stereotype.Service;
import ru.bagautdinov.form.ThemeForm;
import ru.bagautdinov.model.Board;
import ru.bagautdinov.model.User;


@Service
public interface ThemeService {
    void addNewTheme(User owner, Board board, ThemeForm form);
}
