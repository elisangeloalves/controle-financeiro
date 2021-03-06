package com.br.java.carteiradigital.model;

import lombok.*;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@Getter
@Setter
public class CreditEntry extends Entry {

    @Positive
    @NonNull
    private BigDecimal amount = BigDecimal.ZERO;
    private static final EntryType type = EntryType.CREDIT;
}
