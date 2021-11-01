package com.br.java.carteiradigital.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
public class DebitEntry extends Entry {

    @Negative
    @NotNull
    private final BigDecimal amount = BigDecimal.ZERO;
    private final EntryType type = EntryType.DEBIT;

}
