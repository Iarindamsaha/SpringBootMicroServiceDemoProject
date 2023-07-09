package com.arindam.rating.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rating_details")
@Getter
@Setter

public class Rating {

    @Id
    private String ratingId;
    private String userId;
    private String electronicsItemId;
    private int rating;
    private String remarks;

}
