package com.arindam.rating_service.controller;

import com.arindam.rating_service.Response;
import com.arindam.rating_service.entities.Rating;
import com.arindam.rating_service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Response> addElectronicsItems(@RequestBody Rating rating){

        return new ResponseEntity<>(ratingService.addRatings(rating), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Response> getAllRatings(){

        return  new ResponseEntity<>(ratingService.getAllRatings(), HttpStatus.OK);

    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<Response> getRatingByUser(@PathVariable String user_id){

        return new ResponseEntity<>(ratingService.getRatingByUser(user_id),HttpStatus.OK);

    }

    @GetMapping("/devices/{device_id}")
    public ResponseEntity<Response> getRatingByDevice(@PathVariable String device_id){

        return new ResponseEntity<>(ratingService.getRatingByElectronicsItems(device_id),HttpStatus.OK);

    }

}
