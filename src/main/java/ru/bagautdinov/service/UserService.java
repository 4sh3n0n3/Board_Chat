package ru.bagautdinov.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import ru.bagautdinov.form.UserRegistrationForm;

@Service
public interface UserService {

    void saveNewUser(UserRegistrationForm form);
    ObjectError checkUsername(String username);
    ObjectError checkEmail(String email);
}
