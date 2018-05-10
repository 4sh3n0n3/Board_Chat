package ru.bagautdinov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bagautdinov.form.ThemeForm;
import ru.bagautdinov.model.Board;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;
import ru.bagautdinov.repository.ThemeRepository;
import ru.bagautdinov.service.ThemeService;
import ru.bagautdinov.util.ThemeFormMapping;

import java.util.Date;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    ThemeRepository themeRepository;

    @Override
    public void addNewTheme(User owner, Board board, ThemeForm form) {
        themeRepository.save(ThemeFormMapping.transform(board, owner, form));
    }
}
