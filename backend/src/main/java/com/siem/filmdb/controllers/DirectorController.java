package com.siem.filmdb.controllers;

import com.siem.filmdb.models.Director;
import com.siem.filmdb.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {
    final private DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService){
        this.directorService = directorService;
    }

    @PostMapping
    public ResponseEntity<Director> createDirector(@RequestBody Director director){
        Director result = directorService.createDirector(director);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("dummy")
    public ResponseEntity<String> dummy(){
        List<Director> directorList = new ArrayList<>();
        directorList.add(new Director("Tim Burton"));
        directorList.add(new Director("Peter Jackson"));
        directorList.add(new Director("Steven Spielberg"));
        directorList.add(new Director("Robert Zemeckis"));
        directorList.add(new Director("Chrisopher Nolan"));
        directorList.add(new Director("Adam McKay"));
        directorList.add(new Director("Quintin Tarantino"));

        this.directorService.createDirectors(directorList);

        return ResponseEntity.ok("database aangevuld");
    }


    @PutMapping("/{directorId}/directMovie/{movieId}")
    public ResponseEntity<Director> directMovie(@PathVariable Long directorId, @PathVariable Long movieId){
        Director result = directorService.directMovie(directorId,movieId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
