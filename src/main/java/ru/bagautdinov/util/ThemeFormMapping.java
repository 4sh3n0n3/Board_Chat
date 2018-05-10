package ru.bagautdinov.util;

import ru.bagautdinov.form.ThemeForm;
import ru.bagautdinov.model.Board;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;

import java.util.Date;

public class ThemeFormMapping {
    public static Theme transform(Board board, User owner, ThemeForm form) {
        Theme theme = new Theme();
        theme.setCreatedAt(new Date());
        theme.setOwner(owner);
        theme.setBoard(board);
        theme.setName(form.getName());
        theme.setContent(form.getContent());
        return theme;
    }
}
