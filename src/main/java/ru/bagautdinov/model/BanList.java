package ru.bagautdinov.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "ban_gen", sequenceName = "ban_seq", allocationSize = 1)
@Table(name = "ban_list")
public class BanList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ban_gen")
    @Column(name = "id", nullable = false, insertable = false)
    private long id;

    @Column(name = "reason")
    private String reason;

    @OneToOne
    @JoinColumn(name = "banned", unique = true)
    private User banned;

    public long getId() {
        return id;
    }
    public String getReason() {
        return reason;
    }
    public User getBanned() {
        return banned;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public void setBanned(User banned) {
        this.banned = banned;
    }
}
