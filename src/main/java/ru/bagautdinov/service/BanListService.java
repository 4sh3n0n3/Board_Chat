package ru.bagautdinov.service;

import org.springframework.stereotype.Service;
import ru.bagautdinov.model.User;

@Service
public interface BanListService {
    void addBan(String reason, User user);
    void addBanVithoutReason(User user);
    void razban(User user);
}
