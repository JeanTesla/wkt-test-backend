package com.example.test.domain.entity;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "candidates")
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private String rg;

    @NotNull
    private Date birthDate;

    @NotNull
    private String sex;

    private String mother;

    private String father;

    private String email;

    private String zipCode;

    private String address;

    private Integer number;

    private String district;

    private String city;

    @NotNull
    private String state;

    private String landline;

    private String cell;

    @NotNull
    private Double height;

    @NotNull
    private Double weight;

    @NotNull
    private String bloodType;

}
