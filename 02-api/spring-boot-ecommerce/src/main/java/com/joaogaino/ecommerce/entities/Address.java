package com.joaogaino.ecommerce.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;
}
