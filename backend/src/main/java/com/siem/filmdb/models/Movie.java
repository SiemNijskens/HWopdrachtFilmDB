package com.siem.filmdb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Director director;

    @OneToMany
    private List<Actor> actors = new ArrayList<>();

    public Movie(String name){
        this.name = name;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addActors(List<Actor> actors) {
        this.actors.addAll(actors);
    }

    public void setActor(Actor actor) {
        this.actors.add(actor);
    }
}
