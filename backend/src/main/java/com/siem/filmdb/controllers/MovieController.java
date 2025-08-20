package com.siem.filmdb.controllers;

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
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Catch me if you can"));
        movieList.add(new Movie("Back to the future"));
        movieList.add(new Movie("Mars Attacks!"));
        movieList.add(new Movie("Don't Look Up"));
        movieList.add(new Movie("Django Unchained"));
        movieList.add(new Movie("Inception"));
        movieList.add(new Movie("Alice in wonderland"));

        this.movieService.createMovies(movieList);

        return ResponseEntity.ok("database aangevuld");
    }

    //todo change director methode toevoegen?


}
