package com.kovaliv.lab2.dtos.rent;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Setter
@Getter
public class AddRentDto {
    @NotEmpty
    private Date start;
    @NotEmpty
    private Date end;
    @NotEmpty
    private Long carId;
    @NotEmpty
    private Long customerId;
}
