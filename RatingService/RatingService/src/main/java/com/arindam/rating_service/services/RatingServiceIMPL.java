package com.arindam.rating_service.services;

import com.arindam.rating_service.Response;
import com.arindam.rating_service.entities.Rating;
import com.arindam.rating_service.respositories.RatingRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceIMPL implements RatingService{

    @Autowired
    RatingRepository ratingRepository;


    @Autowired
    private Response response;


    @Override
    public Response addRatings(Rating rating) {

        response.setMessage("Rating Added Successfully");
        response.setObject(ratingRepository.save(rating));
        return response;

    }

    @Override
    public Response getAllRatings() {

        response.setMessage("All Ratings Are:-");
        response.setObject(ratingRepository.findAll());
        return response;

    }

    @Override
    public Response getRatingByUser(String user_id) {

        response.setMessage("Rating Of This User Are : - ");
        response.setObject(ratingRepository.findByUserId(user_id));
        return response;

    }

    @Override
    public Response getRatingByElectronicsItems(String device_id) {


        response.setMessage("Rating Of This Device Are : - ");
        response.setObject(ratingRepository.findByElectronicsItemId(device_id));
        return response;

    }
}
