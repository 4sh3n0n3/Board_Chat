package ru.bagautdinov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bagautdinov.model.BanList;
import ru.bagautdinov.model.User;

@Repository
public interface BanListRepository extends JpaRepository<BanList, Long> {
    BanList findByBanned(User banned);
}
