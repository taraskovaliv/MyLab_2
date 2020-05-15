package com.kovaliv.lab2.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
@ToString(exclude = "rents")
@EqualsAndHashCode(exclude = "rents")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 8, nullable = false)
    private String code;

    @OneToMany(mappedBy = "car")
    private List<Rent> rents;
}
