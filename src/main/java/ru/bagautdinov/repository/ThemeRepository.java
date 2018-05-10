package ru.bagautdinov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bagautdinov.model.Board;
import ru.bagautdinov.model.Theme;
import ru.bagautdinov.model.User;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    List<Theme> findByBoard(Board board);
    List<Theme> findByOwner(User user);
    Theme findById(long id);
    List<Theme> findByOwnerAndBoard(User owner, Board board);
}
