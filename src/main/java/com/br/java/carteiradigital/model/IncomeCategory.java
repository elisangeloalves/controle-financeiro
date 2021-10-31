package com.br.java.carteiradigital.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
public class IncomeCategory extends Category implements Serializable {
    private static final long serialVersionUID = 6267609843462833374L;

    private Tag tag = Tag.INCOMING;
}
