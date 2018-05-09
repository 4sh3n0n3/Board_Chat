package ru.bagautdinov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import ru.bagautdinov.form.UserRegistrationForm;
import ru.bagautdinov.model.User;
import ru.bagautdinov.repository.UserRepository;
import ru.bagautdinov.service.UserService;
import ru.bagautdinov.util.UserRegistrationFormMapping;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveNewUser(UserRegistrationForm form) {
        User user = UserRegistrationFormMapping.transform(form);
        userRepository.save(user);
    }

    public ObjectError checkUsername(String username) {
        if (userRepository.findByUsername(username) != null) {
            return new ObjectError("username", "Username already exists!");
        }
        return null;
    }

    public ObjectError checkEmail(String email) {
        if (userRepository.findByEmail(email) != null) {
            return new ObjectError("email", "That email already registered");
        }
        return null;
    }
}
