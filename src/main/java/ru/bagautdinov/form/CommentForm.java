package ru.bagautdinov.form;

import org.hibernate.validator.constraints.NotEmpty;


public class CommentForm {

    @NotEmpty(message = "Комментарий не может быть пустым!")
    private String content;

    private long answerTo;


    public String getContent() {
        return content;
    }
    public long getAnswerTo() {
        return answerTo;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setAnswerTo(long answerTo) {
        this.answerTo = answerTo;
    }
}
