
package com.bda.carrental.controllers;

import com.bda.carrental.entities.dto.VehicleDto;
import com.bda.carrental.services.vehiculoService.VehiculesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    private final VehiculesService vehicleService;

    public VehicleController(VehiculesService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAll(){
        List<VehicleDto> values = vehicleService.getAll();
            return ResponseEntity.ok(values);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getById(@PathVariable("id") Long id) {
        VehicleDto value = vehicleService.getById(id);
        return ResponseEntity.ok(value);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        vehicleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody VehicleDto entity) {
        vehicleService.update(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody VehicleDto entity) {
        vehicleService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}

