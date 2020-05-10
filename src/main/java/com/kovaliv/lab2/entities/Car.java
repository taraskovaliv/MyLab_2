package com.kovaliv.lab2.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@Table(name = "cars")
public class Car {
    @Id
    private Long id;
    @NonNull
    private String name;
    @NonNull
    @Size(max = 8, min = 8)
    private String code;
}
