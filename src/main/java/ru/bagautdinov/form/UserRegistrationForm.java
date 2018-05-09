package ru.bagautdinov.form;

import org.hibernate.validator.constraints.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ScriptAssert(lang = "javascript", script = "_this.repassword.equals(_this.password)", message = "Пароли не совпадают")
public class UserRegistrationForm {
    @NotEmpty(message = "Логин не может быть пустым")
    @Size(min = 4, max = 16, message = "Длина логина должна быть не менее 4 и не более 16 символов")
    @Pattern(regexp = "^[a-zA-Z0-9_]{4,16}$", message = "Используйте только символы латиницы, цифры и _ !")
    private String username;

    @Size(min = 8, message = "Слишком короткий пароль")
    private String password;

    private String repassword;

    @NotEmpty(message = "Пожалуйста, введите email")
    @Email(message = "Неправильно введен Email")
    private String email;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRepassword() {
        return repassword;
    }
    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
