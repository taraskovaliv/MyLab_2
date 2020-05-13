package com.kovaliv.lab2.controllers;

import com.kovaliv.lab2.dtos.car.AddCarDto;
import com.kovaliv.lab2.dtos.car.CarDto;
import com.kovaliv.lab2.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }

    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody AddCarDto addCarDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(addCarDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> update(@RequestBody AddCarDto addCarDto, @PathVariable Long id) {
        return ResponseEntity.ok(carService.update(addCarDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.ok().build();
    }
}
