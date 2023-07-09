package com.arindam.rating.services;

import com.arindam.rating.Response;
import com.arindam.rating.entities.Rating;
import com.arindam.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceIMPL implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;


    @Autowired
    private Response response;


    @Override
    public Response addRatings(Rating rating) {

        String rating_id = UUID.randomUUID().toString();
        rating.setRatingId(rating_id);
        response.setMessage("Rating Added Successfully");
        response.setObject(ratingRepository.save(rating));
        return response;

    }

    @Override
    public List<Rating> getAllRatings() {

        response.setMessage("All Ratings Are:-");
        response.setObject(ratingRepository.findAll());
        return ratingRepository.findAll();

    }

    @Override
    public List<Rating> getRatingByUser(String user_id) {

        response.setMessage("Rating Of This User Are : - ");
        response.setObject(ratingRepository.findByUserId(user_id));
        return ratingRepository.findByUserId(user_id);

    }

    @Override
    public List<Rating> getRatingByElectronicsItems(String device_id) {


        response.setMessage("Rating Of This Device Are : - ");
        response.setObject(ratingRepository.findByElectronicsItemId(device_id));
        return ratingRepository.findByElectronicsItemId(device_id);

    }
}
