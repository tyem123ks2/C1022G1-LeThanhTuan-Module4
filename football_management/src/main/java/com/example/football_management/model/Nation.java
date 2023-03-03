package com.example.football_management.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Nation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    @OneToMany(mappedBy = "nation")
    private Set<Player> playerSet;
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    public Nation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String nationality) {
        this.country = nationality;
    }

    public Set<Player> getPlayerSet() {
        return playerSet;
    }

    public void setPlayerSet(Set<Player> playerSet) {
        this.playerSet = playerSet;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
