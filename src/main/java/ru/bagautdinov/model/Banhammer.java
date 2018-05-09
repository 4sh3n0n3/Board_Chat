package ru.bagautdinov.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "ban_gen", sequenceName = "ban_seq", allocationSize = 1)
@Table(name = "bans")
public class Banhammer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ban_gen")
    @Column(name = "id", nullable = false, insertable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "banned_user", nullable = false)
    private User bannedUser;

    @ManyToOne
    @JoinColumn(name = "admin", nullable = false)
    private User admin;

    @Column(name = "reason")
    private String reason;

    @Column(name = "expires_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiresAt;
}
