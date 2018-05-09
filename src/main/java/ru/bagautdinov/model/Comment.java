package ru.bagautdinov.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@SequenceGenerator(name = "comment_gen", sequenceName = "comment_seq", allocationSize = 1)
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_gen")
    @Column(name = "id", nullable = false, insertable = false)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "theme", nullable = false)
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "writer", nullable = false)
    private User writer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answer_to")
    private Comment answerTo;


    public long getId() {
        return id;
    }
    public Theme getTheme() {
        return theme;
    }
    public User getWriter() {
        return writer;
    }
    public Comment getAnswerTo() {
        return answerTo;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setTheme(Theme theme) {
        this.theme = theme;
    }
    public void setWriter(User writer) {
        this.writer = writer;
    }
    public void setAnswerTo(Comment answerTo) {
        this.answerTo = answerTo;
    }

    /*
    @OneToMany(mappedBy = "answer_to", fetch = FetchType.EAGER)
    private Collection<Comment> answers;
    public void setAnswers(Collection<Comment> answers) {
        this.answers = answers;
    }
    public Collection<Comment> getAnswers() {
        return answers;
    }
    */
}
