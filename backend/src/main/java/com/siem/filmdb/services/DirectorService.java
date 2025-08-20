package com.siem.filmdb.services;

import com.siem.filmdb.models.Director;
import com.siem.filmdb.models.Movie;
import com.siem.filmdb.repositories.DirectorRepository;
import com.siem.filmdb.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    @Autowired
    final private DirectorRepository directorRepository;
    @Autowired
    final private MovieRepository movieRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;
    }

    public Director createDirector(Director director){
        return directorRepository.save(director);
    }


    public List<Director> createDirectors(List<Director> directorList) {
        return this.directorRepository.saveAll(directorList);
    }


    public Director directMovie(Long directorId, Long movieId) {
        // data ophalen
        Movie movie = movieRepository.findById(movieId).get();
        Director director = directorRepository.findById(directorId).get();

        // iets van logica

        // koppelen, data aanpassen
        director.addMovie(movie);
        movie.setDirector(director);

        // opslaan
        return directorRepository.save(director);

    }

}
