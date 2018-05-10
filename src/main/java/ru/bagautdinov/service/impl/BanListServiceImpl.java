package ru.bagautdinov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bagautdinov.model.BanList;
import ru.bagautdinov.model.User;
import ru.bagautdinov.model.enums.Roles;
import ru.bagautdinov.repository.BanListRepository;
import ru.bagautdinov.repository.UserRepository;
import ru.bagautdinov.service.BanListService;
import ru.bagautdinov.service.UserService;

@Service
public class BanListServiceImpl implements BanListService {

    @Autowired
    BanListRepository banListRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void addBan(String reason, User user) {
        BanList ban = new BanList();
        ban.setBanned(user);
        ban.setReason(reason);
        banListRepository.save(ban);
    }

    @Override
    public void addBanVithoutReason(User user) {
        BanList ban = new BanList();
        user.setRole(Roles.ROLE_BANNED);
        userRepository.save(user);
        ban.setBanned(user);
        banListRepository.save(ban);
    }

    @Override
    public void razban(User user) {
        user.setRole(Roles.ROLE_USER);
        userRepository.save(user);
        banListRepository.delete(banListRepository.findByBanned(user));
    }
}
