package com.example.securewebapplication.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "qualities")
@NamedQuery(name  = "Quality.byUser", query = "select qual from Quality  qual where qual.user.id = :userId ")
public class Quality implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @SequenceGenerator(name = "qualitiesSeqGenerator", sequenceName = "qualities_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Quality() {}

    public Quality(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quality quality = (Quality) o;
        return Objects.equals(id, quality.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
