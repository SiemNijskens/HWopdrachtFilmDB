package com.siem.filmdb.services;

import com.siem.filmdb.models.Movie;
import com.siem.filmdb.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    final private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    public List<Movie> createMovies(List<Movie> movies)  {
        return this.movieRepository.saveAll(movies);
    }
}
