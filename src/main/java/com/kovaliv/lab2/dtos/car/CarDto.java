package com.kovaliv.lab2.dtos.car;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Builder
public class CarDto {
    @Min(0)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String code;
}
