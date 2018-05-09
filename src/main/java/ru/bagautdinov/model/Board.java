package ru.bagautdinov.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Collection;

@Entity
@SequenceGenerator(name = "board_gen", sequenceName = "board_seq", allocationSize = 1)
@Table(name = "boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_gen")
    @Column(name = "id", nullable = false, insertable = false)
    private long id;

    @Column(name = "name", unique = true, nullable = false)
    private long name;

    @Column(name = "link", unique = true, nullable = false)
    private String link;

    public void setId(long id) {
        this.id = id;
    }
    public void setName(long name) {
        this.name = name;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public long getId() {
        return id;
    }
    public long getName() {
        return name;
    }
    public String getLink() {
        return link;
    }

}
