package com.siem.filmdb.services;

import com.siem.filmdb.models.Actor;
import com.siem.filmdb.models.Movie;
import com.siem.filmdb.repositories.ActorRepository;
import com.siem.filmdb.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    @Autowired
    final private ActorRepository actorRepository;
    @Autowired
    final private MovieRepository movieRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    public Actor createActor(Actor actor){
        return actorRepository.save(actor);
    }

    public List<Actor> createActors(List<Actor> actors) {
        return this.actorRepository.saveAll(actors);
    }

    public Actor actInMovie(Long actorId, Long movieId) {
        // data ophalen
        Movie movie = movieRepository.findById(movieId).get();
        Actor actor = actorRepository.findById(actorId).get();

        // iets van logica

        // koppelen, data aanpassen
        actor.addMovie(movie);
        movie.setActor(actor);

        // opslaan
        return actorRepository.save(actor);

    }


}
