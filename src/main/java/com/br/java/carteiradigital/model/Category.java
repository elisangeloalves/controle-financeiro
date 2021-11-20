package com.br.java.carteiradigital.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "categories")
@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 3911865595525212824L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String label;
    @NonNull
    private Tag tag;
    @ManyToOne
    private User user;
}

