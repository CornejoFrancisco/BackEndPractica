package com.bda.carrental.repositories;


import com.bda.carrental.entities.CarRentalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRentalDetailsRepository
        extends JpaRepository<CarRentalDetails, Long> {
}

