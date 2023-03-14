package com.joaogaino.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "country")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String code;

    private String name;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<State> states;
}
