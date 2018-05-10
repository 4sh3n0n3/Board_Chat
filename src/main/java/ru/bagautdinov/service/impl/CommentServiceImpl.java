package ru.bagautdinov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bagautdinov.model.Comment;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;
import ru.bagautdinov.repository.CommentRepository;
import ru.bagautdinov.service.CommentService;

import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void addNewComment(Theme theme, User owner, Comment answerTo) {
        Comment comment = new Comment();
        comment.setAnswerTo(comment);
        comment.setTheme(theme);
        comment.setWriter(owner);
        comment.setCreatedAt(new Date());
        commentRepository.save(comment);
    }
}
