package com.br.java.carteiradigital.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
public class OutcomeCategory extends Category implements Serializable {
    private final Tag tag = Tag.OUTCOMING;

    private static final long serialVersionUID = 6267609843462833374L;
}
