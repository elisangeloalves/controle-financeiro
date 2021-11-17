package com.br.java.carteiradigital.model;

import lombok.*;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
@Setter
public class DebitEntry extends Entry {

    @Negative
    @NonNull
    private BigDecimal amount = BigDecimal.ZERO;
    private static final EntryType type = EntryType.DEBIT;
}
