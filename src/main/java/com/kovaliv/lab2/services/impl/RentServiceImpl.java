package com.kovaliv.lab2.services.impl;

import com.kovaliv.lab2.dtos.rent.AddRentDto;
import com.kovaliv.lab2.dtos.rent.RentDto;
import com.kovaliv.lab2.entities.Rent;
import com.kovaliv.lab2.repositories.CarRepo;
import com.kovaliv.lab2.repositories.CustomerRepo;
import com.kovaliv.lab2.repositories.RentRepo;
import com.kovaliv.lab2.services.RentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentServiceImpl implements RentService {
    private final CarRepo carRepo;
    private final RentRepo rentRepo;
    private final ModelMapper modelMapper;
    private final CustomerRepo customerRepo;

    @Override
    public List<RentDto> getAll() {
        return rentRepo.findAll().stream()
                .map(rent -> modelMapper.map(rent, RentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RentDto save(AddRentDto addRentDto) {
        return null;
    }

    @Override
    public RentDto update(RentDto rentDto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Rent> rent = rentRepo.findById(id);
        if (rent.isPresent()) {
            rentRepo.delete(rent.get());
        } else {
            throw new RuntimeException("Rent not found");
        }
    }
}
