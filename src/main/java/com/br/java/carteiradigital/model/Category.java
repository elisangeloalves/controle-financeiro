package com.br.java.carteiradigital.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "categories")
//@RequiredArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public abstract class Category implements Serializable {
    private static final long serialVersionUID = 3911865595525212824L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @ManyToOne
    private User user;
}

