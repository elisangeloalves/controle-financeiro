package com.br.java.carteiradigital.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "authorities")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Privilege implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Collection<Role> roles;
}