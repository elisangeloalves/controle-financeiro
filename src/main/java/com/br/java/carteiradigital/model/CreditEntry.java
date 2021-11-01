package com.br.java.carteiradigital.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
public class CreditEntry extends Entry {

    @Positive
    @NotNull
    private final BigDecimal amount = BigDecimal.ZERO;
    private final EntryType type = EntryType.CREDIT;
}
