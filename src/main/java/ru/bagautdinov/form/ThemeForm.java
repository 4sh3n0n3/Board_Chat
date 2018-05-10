package ru.bagautdinov.form;

import org.hibernate.validator.constraints.NotEmpty;

public class ThemeForm {

    @NotEmpty(message = "Оставьте комментарий!")
    private String content;

    @NotEmpty(message = "Имя не должно быть пустым")
    private String name;

    public String getContent() {
        return content;
    }
    public String getName() {
        return name;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setName(String name) {
        this.name = name;
    }
}
