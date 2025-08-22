package com.siem.filmdb.controllers;

import com.siem.filmdb.models.Actor;
import com.siem.filmdb.models.Director;
import com.siem.filmdb.models.Movie;
import com.siem.filmdb.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("movie")
public class MovieController {
    final private MovieService movieService;

    //private List<Actor> actorsInCatchMeIfYouCan = new ArrayList<>();
    //actorsInCatch.add(new Actor("Leonardo DiCaprio"))
    //Leonardo DiCaprio
    //Tom Hanks


    @Autowired
    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie result = movieService.createMovie(movie);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);

    }

    @PostMapping("dummy")
    public ResponseEntity<String> dummy(){
        Actor leonardoDiCaprio = (new Actor("Leonardo DiCaprio"));
        Actor tomHanks = (new Actor("Tom Hanks"));
        Actor michaelJFox = (new Actor("Michael J. Fox"));
        Actor christopherLloyd = (new Actor("Christopher Lloyd"));
        Actor jackNicholson = (new Actor("Jack Nicholson"));
        Actor pierceBrosnan =  (new Actor("Pierce Brosnan"));
        Actor jenniferLawrence = (new Actor("Jennifer Lawrence"));
        Actor josephGordonLevitt = (new Actor("Joseph Gordon-Levitt"));
        Actor elliotPage = (new Actor("Elliot Page"));
        Actor jamieFoxx = (new Actor("Jamie Foxx"));
        Actor christopherWaltz = (new Actor("Christopher Waltz"));
        Actor johnnyDepp = (new Actor("Johnny Depp"));
        Actor helenaBonhamCarter = (new Actor("Helena Bonham Carter"));
        Actor anneHathaway = (new Actor("Anne Hathaway"));

        List<Actor> actorList = new ArrayList<>();
        actorList.add(leonardoDiCaprio);
        actorList.add(tomHanks);
        actorList.add(michaelJFox);
        actorList.add(christopherLloyd);
        actorList.add(jackNicholson);
        actorList.add(pierceBrosnan);
        actorList.add(jenniferLawrence);
        actorList.add(josephGordonLevitt);
        actorList.add(elliotPage);
        actorList.add(jamieFoxx);
        actorList.add(christopherWaltz);
        actorList.add(johnnyDepp);
        actorList.add(helenaBonhamCarter);
        actorList.add(anneHathaway);

        List<Actor> actorsInCatchMeIfYouCan = new ArrayList<>();
        actorsInCatchMeIfYouCan.add(leonardoDiCaprio);
        actorsInCatchMeIfYouCan.add(tomHanks);

        List<Actor> actorsInBackToTheFuture = new ArrayList<>();
        actorsInBackToTheFuture.add(michaelJFox);
        actorsInBackToTheFuture.add(christopherLloyd);

        List<Actor> actorsInMarsAttacks = new ArrayList<>();
        actorsInMarsAttacks.add(jackNicholson);
        actorsInMarsAttacks.add(pierceBrosnan);
        actorsInMarsAttacks.add(michaelJFox);

        List<Actor> actorsInDontLookUp = new ArrayList<>();
        actorsInDontLookUp.add(leonardoDiCaprio);
        actorsInDontLookUp.add(jenniferLawrence);

        List<Actor> actorsInDjangoUnchained = new ArrayList<>();
        actorsInDjangoUnchained.add(jamieFoxx);
        actorsInDjangoUnchained.add(christopherWaltz);
        actorsInDjangoUnchained.add(leonardoDiCaprio);

        List<Actor> actorsInInception = new ArrayList<>();
        actorsInInception.add(leonardoDiCaprio);
        actorsInInception.add(josephGordonLevitt);
        actorsInInception.add(elliotPage);

        List<Actor> actorsInAliceInWonderland = new ArrayList<>();
        actorsInAliceInWonderland.add(johnnyDepp);
        actorsInAliceInWonderland.add(helenaBonhamCarter);
        actorsInAliceInWonderland.add(anneHathaway);

        Director timBurton = (new Director("Tim Burton"));
        Director peterJackson = (new Director("Peter Jackson"));
        Director stevenSpielberg = (new Director("Steven Spielberg"));
        Director robertZemeckis = (new Director("Robert Zemeckis"));
        Director chrisopherNolan = (new Director("Chrisopher Nolan"));
        Director adamMcKay = (new Director("Adam McKay"));
        Director quintinTarantino = (new Director("Quintin Tarantino"));

        List<Director> directorList = new ArrayList<>();
        directorList.add(timBurton);
        directorList.add(peterJackson);
        directorList.add(stevenSpielberg);
        directorList.add(robertZemeckis);
        directorList.add(chrisopherNolan);
        directorList.add(adamMcKay);
        directorList.add(quintinTarantino);

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Catch me if you can", actorsInCatchMeIfYouCan,stevenSpielberg));
        movieList.add(new Movie("Back to the future", actorsInBackToTheFuture, robertZemeckis));
        movieList.add(new Movie("Mars Attacks!", actorsInMarsAttacks, timBurton));
        movieList.add(new Movie("Don't Look Up", actorsInDontLookUp, adamMcKay));
        movieList.add(new Movie("Django Unchained", actorsInDjangoUnchained, quintinTarantino));
        movieList.add(new Movie("Inception", actorsInInception, chrisopherNolan));
        movieList.add(new Movie("Alice in wonderland", actorsInAliceInWonderland, timBurton));

        this.movieService.createMovies(movieList);

        return ResponseEntity.ok("database aangevuld");
    }

    //todo change director methode toevoegen?


}
