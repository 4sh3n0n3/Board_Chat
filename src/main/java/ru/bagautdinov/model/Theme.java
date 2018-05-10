package ru.bagautdinov.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@SequenceGenerator(name = "theme_gen", sequenceName = "theme_seq", allocationSize = 1)
@Table(name = "themes")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "theme_gen")
    @Column(name = "id", nullable = false, insertable = false)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner", nullable = false)
    private User owner;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "board", nullable = false)
    private Board board;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();


    public void setId(long id) {
        this.id = id;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }
    public User getOwner() {
        return owner;
    }
    public Board getBoard() {
        return board;
    }
    public String getName() {
        return name;
    }
    public String getContent() {
        return content;
    }
    public Date getCreatedAt() {
        return createdAt;
    }



    @OneToMany(mappedBy = "theme", fetch = FetchType.LAZY)
    private Collection<Comment> comments;
    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
    public Collection<Comment> getComments() {
        return comments;
    }
}
