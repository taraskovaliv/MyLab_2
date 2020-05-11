package com.kovaliv.lab2.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@ToString(exclude = "customer")
@Table(name = "rents")
public class Rent {
    @Id
    private Long id;

    @Column(nullable = false)
    private ZonedDateTime startOfRent;

    @Column(nullable = false)
    private ZonedDateTime endOfRent;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;
}
