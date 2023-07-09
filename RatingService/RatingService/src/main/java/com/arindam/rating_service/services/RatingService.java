package com.arindam.rating_service.services;

import com.arindam.rating_service.Response;
import com.arindam.rating_service.entities.Rating;

public interface RatingService {

    Response addRatings(Rating rating);
    Response getAllRatings();
    Response getRatingByUser(String user_id);
    Response getRatingByElectronicsItems(String device_id);


}
