package com.arindam.user.service.services;

import com.arindam.user.service.Response;
import com.arindam.user.service.entity.ElectronicsDevices;
import com.arindam.user.service.entity.Rating;
import com.arindam.user.service.entity.User;
import com.arindam.user.service.exceptions.UserException;
import com.arindam.user.service.external_services.ElectronicsDevicesServices;
import com.arindam.user.service.repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServicesIMPL implements UserServices{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    Response response;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ElectronicsDevicesServices electronicsDevicesServices;


    @Override
    public Response saveUser(User user) {

        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        userRepo.save(user);
        response.setMessage("User Added Successfully");
        response.setObject(user);
        return response;
    }

    @Override
    public Response getAllUsers() {

        List<User> allUsers = userRepo.findAll();
        response.setObject(allUsers);
        response.setMessage("All Users Are");
        return response;
    }

    @Override
    public User getSingleUser(String id) {

        User user = userRepo.findById(id).orElseThrow(()-> new UserException
                ("Resource Not Found", HttpStatus.BAD_REQUEST));
        Rating[] arrayOfRating = restTemplate.getForObject
                ("http://RATING-SERVICE/ratings/user/{user_id}",Rating[].class,user.getUserId());
        List<Rating> checkObject = Arrays.stream(arrayOfRating).toList();



        List<Rating> ratingList = checkObject.stream().map(rating -> {
            //todo: api call
//             ResponseEntity<ElectronicsDevices> deviceResponse = restTemplate.getForEntity
//                     ("http://DEVICE-DETAILS/devices/{electronicsItemId}",
//                             ElectronicsDevices.class,rating.getElectronicsItemId());
             ElectronicsDevices devices = electronicsDevicesServices.getDevice(rating.getElectronicsItemId());

             //todo: set device rating
             rating.setElectronicsDevices(devices);

             //todo: return
             return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;

    }

    @Override
    public Response deleteOneUser(String id) {

        response.setObject(userRepo.findById(id).orElseThrow(()-> new UserException
                ("Resource Not Found", HttpStatus.BAD_REQUEST)));
        userRepo.deleteById(id);
        response.setMessage("User Deleted Successfully");
        return response;
    }

    @Override
    public Response updateSingleUser(String id,User user) {

        User userCheck = userRepo.findById(id).orElseThrow
                (()-> new UserException("Resource Not Found", HttpStatus.BAD_REQUEST));

            userCheck.setUsername(user.getUsername());
            userCheck.setEmail(user.getEmail());
            userCheck.setAbout(user.getAbout());
            userRepo.save(userCheck);

        response.setObject(userCheck);
        response.setMessage("User Updated Successfully");
        return response;

    }
}
