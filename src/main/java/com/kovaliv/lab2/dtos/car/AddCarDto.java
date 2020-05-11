package com.kovaliv.lab2.dtos.car;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class AddCarDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String code;
}
