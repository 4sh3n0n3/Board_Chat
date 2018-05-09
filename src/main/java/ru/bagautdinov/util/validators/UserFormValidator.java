package ru.bagautdinov.util.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.bagautdinov.form.UserRegistrationForm;

public class UserFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistrationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegistrationForm form = (UserRegistrationForm) o;

    }
}
