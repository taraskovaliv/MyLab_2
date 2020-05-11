package com.kovaliv.lab2.entities;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@EqualsAndHashCode(exclude = "rents")
@Table(name = "cars")
public class Car {
    @Id
    private Long id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 8, nullable = false)
    private String code;

    @OneToMany(mappedBy = "car")
    private List<Rent> rents;
}
