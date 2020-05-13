package com.kovaliv.lab2.services;

import com.kovaliv.lab2.dtos.rent.AddRentDto;
import com.kovaliv.lab2.dtos.rent.RentDto;

import java.util.List;

public interface RentService {
    List<RentDto> getAll();

    RentDto save(AddRentDto addRentDto);

    RentDto update(RentDto rentDto);

    void delete(Long id);
}
