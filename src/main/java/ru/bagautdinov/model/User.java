package ru.bagautdinov.model;

import ru.bagautdinov.model.enums.Roles;
import javax.persistence.*;
import java.util.Collection;

@Entity
@SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @Column(name = "id", nullable = false, insertable = false)
    private long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Roles role;

    public long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public Roles getRole() {
        return role;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRole(Roles role) {
        this.role = role;
    }


    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Collection<Theme> themes;
    public void setThemes(Collection<Theme> themes) {
        this.themes = themes;
    }
    public Collection<Theme> getThemes() {
        return themes;
    }


    @OneToMany(mappedBy = "writer", fetch = FetchType.EAGER)
    private Collection<Comment> comments;
    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
    public Collection<Comment> getComments() {
        return comments;
    }

    @OneToOne(mappedBy = "banned")
    private BanList banList;
    public void setBanList(BanList banList) {
        this.banList = banList;
    }
    public BanList getBanList() {
        return banList;
    }
}
