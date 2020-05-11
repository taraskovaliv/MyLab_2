package com.kovaliv.lab2.dtos.rent;

import com.kovaliv.lab2.dtos.car.CarDto;
import com.kovaliv.lab2.dtos.customer.CustomerDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Setter
@Getter
@Builder
public class RentDto {
    @NotEmpty
    private Date start;
    @NotEmpty
    private Date end;
    @NotEmpty
    private CarDto car;
    @NotEmpty
    private CustomerDto customerDto;
}
