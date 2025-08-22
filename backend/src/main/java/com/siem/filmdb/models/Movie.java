package com.siem.filmdb.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    private Director director;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Actor> actors = new ArrayList<>();

    public Movie(String name){
        this.name = name;
    }

    public Movie(String name, List<Actor> actors, Director director){
        this.name = name;
        this.actors = actors;
        this.director = director;
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

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }
}
