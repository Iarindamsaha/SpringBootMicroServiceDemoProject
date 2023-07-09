package com.arindam.rating.controller;

import com.arindam.rating.Response;
import com.arindam.rating.entities.Rating;
import com.arindam.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Response> addElectronicsItems(@RequestBody Rating rating){

        return new ResponseEntity<>(ratingService.addRatings(rating), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){

        return ResponseEntity.ok(ratingService.getAllRatings());

    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String user_id){

        return ResponseEntity.ok(ratingService.getRatingByUser(user_id));

    }

    @GetMapping("/devices/{device_id}")
    public ResponseEntity<List<Rating>> getRatingByDevice(@PathVariable String device_id){

        return ResponseEntity.ok(ratingService.getRatingByUser(device_id));

    }

}
