package com.arindam.rating.services;

import com.arindam.rating.Response;
import com.arindam.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    Response addRatings(Rating rating);
    List<Rating> getAllRatings();
    List<Rating> getRatingByUser(String user_id);
    List<Rating> getRatingByElectronicsItems(String device_id);

}
