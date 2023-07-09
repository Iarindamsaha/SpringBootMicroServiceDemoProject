package com.arindam.user.service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private String ratingId;
    private String userId;
    private String electronicsItemId;
    private int rating;
    private String remarks;

    private ElectronicsDevices electronicsDevices;

}
