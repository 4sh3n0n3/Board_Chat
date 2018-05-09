package ru.bagautdinov.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.bagautdinov.form.UserRegistrationForm;
import ru.bagautdinov.model.User;
import ru.bagautdinov.model.enums.Roles;

public class UserRegistrationFormMapping {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User transform(UserRegistrationForm form) {
        if (form == null) {
            return null;
        }
        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setRole(Roles.ROLE_USER);
        user.setPassword(encoder.encode(form.getPassword()));
        return user;
    }
}
