package com.arindam.user.service.controller;

import com.arindam.user.service.Response;
import com.arindam.user.service.entity.User;
import com.arindam.user.service.services.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping
    public ResponseEntity<Response> createNewUser(@RequestBody User user){

        return new ResponseEntity<>(userServices.saveUser(user), HttpStatus.OK);

    }

    @GetMapping("/{user_id}")
    @CircuitBreaker(name = "userCircuitBreaker",fallbackMethod = "ratingFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String user_id){

        User user = userServices.getSingleUser(user_id);
        return ResponseEntity.ok(user);

    }

    //todo: fallback method for circuit breaker
    public ResponseEntity<User> ratingFallback(String userId, Exception ex){

        log.info("Fallback is executed Because Service is down {}",ex.getMessage());
        User user = User.builder().
                username("Circuit Breaker").
                email("circuitbreaker@breaker.com").
                about("Service is Currently Down").
                userId("12345").
                build();
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateUserById(@PathVariable String id, @RequestBody User user){

        return new ResponseEntity<>(userServices.updateSingleUser(id,user),HttpStatus.OK);

    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<Response> deleteSingleUser(@PathVariable String user_id){

        return new ResponseEntity<>(userServices.deleteOneUser(user_id),HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Response> getAllUsers(){

        return new ResponseEntity<>(userServices.getAllUsers(),HttpStatus.OK);

    }


}
