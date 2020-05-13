package com.kovaliv.lab2.controllers;

import com.kovaliv.lab2.dtos.rent.AddRentDto;
import com.kovaliv.lab2.dtos.rent.RentDto;
import com.kovaliv.lab2.services.RentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/rent")
public class RentController {
    private final RentService rentService;

    @GetMapping
    public ResponseEntity<List<RentDto>> getAll() {
        return ResponseEntity.ok(rentService.getAll());
    }

    @PostMapping
    public ResponseEntity<RentDto> save(@RequestBody AddRentDto addRentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rentService.save(addRentDto));
    }

    @PutMapping
    public ResponseEntity<RentDto> update(@RequestBody RentDto rentDto) {
        return ResponseEntity.ok(rentService.update(rentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        rentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
