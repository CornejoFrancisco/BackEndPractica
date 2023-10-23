package com.bda.carrental.services.CarRentalDetails;

import com.bda.carrental.entities.CarRentalDetails;
import com.bda.carrental.entities.dto.CarRentalDetailsDto;
import com.bda.carrental.entities.dto.transformations.CarRentalDetailsMapper.CarRentalDetailsDtoMapper;
import com.bda.carrental.entities.dto.transformations.CarRentalDetailsMapper.CarRentalDetailsMapper;
import com.bda.carrental.repositories.CarRentalDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CarRentalDetailsServiceImpl implements CarRentalDetailsService{
    private final CarRentalDetailsRepository carRentalDetailsRepository;
    private final CarRentalDetailsDtoMapper carRentalDetailsDtoMapper;

    private final CarRentalDetailsMapper carRentalDetailsMapper;

    public CarRentalDetailsServiceImpl(CarRentalDetailsRepository carRentalDetailsRepository
            , CarRentalDetailsDtoMapper carRentalDetailsDtoMapper,
            CarRentalDetailsMapper carRentalDetailsMapper) {
        this.carRentalDetailsRepository = carRentalDetailsRepository;
        this.carRentalDetailsDtoMapper = carRentalDetailsDtoMapper;
        this.carRentalDetailsMapper = carRentalDetailsMapper;
    }

    @Override
    public void add(CarRentalDetailsDto entity) {
        CarRentalDetails carRentalDetails = new CarRentalDetails();
        carRentalDetails.setId(entity.getId());
        carRentalDetails.setDestination(entity.getDestination());
        carRentalDetails.setTravelTotalHours(entity.getTravelTotalHours());
        carRentalDetailsRepository.save(carRentalDetails);
    }

    @Override
    public CarRentalDetailsDto getById(Long id) {
        Optional<CarRentalDetails> carRentalDetails = carRentalDetailsRepository.findById(id);
        return carRentalDetails
                .map(carRentalDetailsDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<CarRentalDetailsDto> getAll() {
        List<CarRentalDetails> values = carRentalDetailsRepository.findAll();
        return values.stream()
                .map(carRentalDetailsDtoMapper)
                .toList();
    }

    @Override
    public CarRentalDetailsDto delete(Long id){
        Optional<CarRentalDetails> optionalCarRentalDetails = carRentalDetailsRepository
                .findById(id);
        optionalCarRentalDetails.ifPresent(carRentalDetailsRepository::delete);
        return optionalCarRentalDetails
                .map(carRentalDetailsDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(CarRentalDetailsDto entity) {
        Optional<CarRentalDetails> carRentalDetails = Stream.of(entity)
                .map(carRentalDetailsMapper)
                .findFirst();
        carRentalDetails.ifPresent(carRentalDetailsRepository:: save);
    }
}
