package com.kovaliv.lab2.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@Table(name = "cars")
public class Car {
    @Id
    private Long id;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 8, nullable = false)
    private String code;
}
