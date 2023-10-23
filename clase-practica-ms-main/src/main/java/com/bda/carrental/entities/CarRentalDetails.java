package com.bda.carrental.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car_rental_details")
@AllArgsConstructor
@Data
@NoArgsConstructor(force = true)

public class CarRentalDetails {

    @Id
    @GeneratedValue(generator = "car_rental_details")
    @TableGenerator(name = "car_rental_details", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="car_rental_details",
            initialValue=1, allocationSize=1)

    private long id;

    @ManyToOne
    @JoinColumn(name = "car_rental_id")
    private CarRental carRentalId;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicle vehicleId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

    @JoinColumn(name = "picked_up_place")
    private Integer pickedUpPlace;

    @Column(name = "destination")
    private Integer destination;

    @Column(name = "travel_total_hours")
    private Integer travelTotalHours;

}
