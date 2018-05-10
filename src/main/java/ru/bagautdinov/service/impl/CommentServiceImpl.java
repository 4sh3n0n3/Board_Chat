package ru.bagautdinov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bagautdinov.form.CommentForm;
import ru.bagautdinov.model.Comment;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;
import ru.bagautdinov.repository.CommentRepository;
import ru.bagautdinov.service.CommentService;
import ru.bagautdinov.util.CommentFormMapping;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void addNewComment(CommentForm form, User writer, Theme theme) {
        Comment answer = commentRepository.findById(form.getAnswerTo());
        Comment comment = CommentFormMapping.transform(form, writer, theme, answer);
        commentRepository.save(comment);
    }
}
