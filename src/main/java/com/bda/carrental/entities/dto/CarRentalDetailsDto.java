package com.bda.carrental.entities.dto;


import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRentalDetailsDto {
    private long id;
    private long carRentalId;
    private long vehicleId;
    private long clientId;
    private Integer pickedUpPlace;
    private Integer destination;
    private Integer travelTotalHours;
}
