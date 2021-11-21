package com.br.java.carteiradigital.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target(value = ElementType.FIELD)
public @interface UniqueValue {
    String message() default "This field can not be duplicated in the database!";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};

    String field();

    Class<?> domainClass();
}
