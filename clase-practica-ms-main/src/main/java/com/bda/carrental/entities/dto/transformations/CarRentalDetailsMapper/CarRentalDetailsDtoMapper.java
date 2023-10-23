package com.bda.carrental.entities.dto.transformations.CarRentalDetailsMapper;

import com.bda.carrental.entities.CarRentalDetails;
import com.bda.carrental.entities.dto.CarRentalDetailsDto;
import com.bda.carrental.entities.dto.CarRentalDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CarRentalDetailsDtoMapper implements Function<CarRentalDetails, CarRentalDetailsDto> {
    @Override
    public CarRentalDetailsDto apply(CarRentalDetails carRentalDetails) {
        return new CarRentalDetailsDto(
                carRentalDetails.getId(),
                carRentalDetails.getVehicleId().getId(),
                carRentalDetails.getCarRentalId().getId(),
                carRentalDetails.getClientId().getId(),
                carRentalDetails.getPickedUpPlace(),
                carRentalDetails.getDestination(),
                carRentalDetails.getTravelTotalHours()
                );
    }
}
