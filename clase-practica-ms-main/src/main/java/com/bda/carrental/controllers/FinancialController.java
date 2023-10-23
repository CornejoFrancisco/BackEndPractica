package com.bda.carrental.controllers;


import com.bda.carrental.entities.dto.CarRentalDetailsDto;
import com.bda.carrental.services.CarRentalDetails.CarRentalDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/financia")
public class FinancialController {
    private final CarRentalDetailsService carRentalDetailsService;

    public FinancialController(CarRentalDetailsService carRentalDetailsService) {
        this.carRentalDetailsService = carRentalDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<CarRentalDetailsDto>> getAll() {
        List<CarRentalDetailsDto> values = carRentalDetailsService.getAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarRentalDetailsDto> getById(@PathVariable("id") Long id) {
        CarRentalDetailsDto value = carRentalDetailsService.getById(id);
        return ResponseEntity.ok(value);
    }

}

/*
1. FinancialController que tiene los siguientes endpoints:
        1. Listado de alquileres a cobrar a la compañía, (Ver Nombre de la compañía del cliente, nombre completo del cliente
        que alquilo, el codigo del alquiler, datos del vehículo, fecha de entrega y de devolución del vehículo y el
        total a cobrar para esa compañia (cost_hour del vehiculo por travel_total_hours))
        2. Ingresar un pago, en el body viajan los datos de la fecha de pago, el monto total y el listado de codigos de
        alquileres que paga


 */