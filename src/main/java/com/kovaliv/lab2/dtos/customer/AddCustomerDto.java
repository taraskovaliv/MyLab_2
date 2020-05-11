package com.kovaliv.lab2.dtos.customer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AddCustomerDto {
    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;
}
