package com.kovaliv.lab2.entities;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@Table(name = "customers")
@EqualsAndHashCode(exclude = "rents")
public class Customer {
    @Id
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String surname;

    @OneToMany(mappedBy = "customer")
    private List<Rent> rents;
}