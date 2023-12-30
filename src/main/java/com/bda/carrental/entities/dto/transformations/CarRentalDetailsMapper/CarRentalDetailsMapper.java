package com.bda.carrental.entities.dto.transformations.CarRentalDetailsMapper;
import com.bda.carrental.entities.CarRentalDetails;
import com.bda.carrental.entities.dto.CarRentalDetailsDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class CarRentalDetailsMapper implements Function<CarRentalDetailsDto, CarRentalDetails> {
    @Override
    public CarRentalDetails apply(CarRentalDetailsDto carRentalDetailsDto){
        return new CarRentalDetails(
                carRentalDetailsDto.getId(),
                null,
                null,
                null,
                carRentalDetailsDto.getDestination(),
                carRentalDetailsDto.getPickedUpPlace(),
                carRentalDetailsDto.getTravelTotalHours());

    }
}
