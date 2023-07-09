package com.arindam.rating.repository;

import com.arindam.rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {
    List<Rating> findByUserId(String userId);

    List<Rating> findByElectronicsItemId(String deviceId);


}
