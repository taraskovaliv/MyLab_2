package com.kovaliv.lab2.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@Builder
@EqualsAndHashCode
@ToString(exclude = "customer")
@Table(name = "rents")
public class Rent {
    @Id
    private Long id;

    @Column(nullable = false)
    private Date startOfRent;

    @Column(nullable = false)
    private Date endOfRent;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;
}
