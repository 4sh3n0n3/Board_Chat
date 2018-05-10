package ru.bagautdinov.util;

import ru.bagautdinov.form.CommentForm;
import ru.bagautdinov.model.Comment;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;

import java.util.Date;

public class CommentFormMapping {

    public static Comment transform(CommentForm form, User writer, Theme theme, Comment answer) {
        Comment comment = new Comment();
        comment.setCreatedAt(new Date());
        comment.setWriter(writer);
        comment.setTheme(theme);
        comment.setAnswerTo(answer);
        comment.setContent(form.getContent());
        return comment;
    }
}
