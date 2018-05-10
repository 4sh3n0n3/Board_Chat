package ru.bagautdinov.service;

import org.springframework.stereotype.Service;
import ru.bagautdinov.model.Comment;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;

@Service
public interface CommentService {
    void addNewComment(Theme theme, User owner, Comment answerTo);
}
