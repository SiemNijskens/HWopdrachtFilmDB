package com.siem.filmdb.controllers;

import com.siem.filmdb.models.Actor;
import com.siem.filmdb.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    final private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor){
        Actor result = actorService.createActor(actor);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("dummy")
    public ResponseEntity<String> dummy(){
        List<Actor> actorList = new ArrayList<>();
        actorList.add(new Actor("Leonardo DiCaprio"));
        actorList.add(new Actor("Tom Hanks"));
        actorList.add(new Actor("Michael J. Fox"));
        actorList.add(new Actor("Christopher Lloyd"));
        actorList.add(new Actor("Jack Nicholson"));
        actorList.add(new Actor("Pierce Brosnan"));
        actorList.add(new Actor("Jennifer Lawrence"));
        actorList.add(new Actor("Joseph Gordon-Levitt"));
        actorList.add(new Actor("Elliot Page"));
        actorList.add(new Actor("Jamie Foxx"));
        actorList.add(new Actor("Christopher Waltz"));
        actorList.add(new Actor("Johnny Depp"));
        actorList.add(new Actor("Helena Bonham Carter"));
        actorList.add(new Actor("Anne Hathaway"));

        this.actorService.createActors(actorList);

        return ResponseEntity.ok("database aangevuld");
    }


    @PutMapping("/{actorId}/actInMovie/{movieId}")
    public ResponseEntity<Actor> actInMovie(@PathVariable Long actorId, @PathVariable Long movieId){
        Actor result = actorService.actInMovie(actorId,movieId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
