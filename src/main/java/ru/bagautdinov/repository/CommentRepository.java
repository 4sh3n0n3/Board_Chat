package ru.bagautdinov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bagautdinov.model.Comment;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTheme(Theme theme);
    List<Comment> findByWriter(User writer);
    List<Comment> findByAnswerTo(Comment comment);
    Comment findById(long id);
    void deleteById(long id);
}
