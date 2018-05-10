package ru.bagautdinov.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import ru.bagautdinov.form.UserRegistrationForm;
import ru.bagautdinov.model.User;


@Service
public interface UserService {

    void saveNewUser(UserRegistrationForm form);
    ObjectError checkUsername(String username);
    ObjectError checkEmail(String email);
    User getAuthenticatedUser();

}
