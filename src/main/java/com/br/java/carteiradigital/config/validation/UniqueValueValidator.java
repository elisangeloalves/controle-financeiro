package com.br.java.carteiradigital.config.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Slf4j
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object > {

    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue params) {
        this.domainAttribute = params.field();
        this.klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
         Query query = manager.createQuery("SELECT 1 FROM "+klass.getSimpleName()+" WHERE "+domainAttribute+" =:value");

         query.setParameter("value", value);
         List<?> list = query.getResultList();

        Assert.state(list.size() <=1,
                "A Problem has been detected in the aplication: \nthe value '"
                        +value+"' in the field '"+domainAttribute+"' for class '"
                        +klass.getSimpleName()+ "' was founded duplicated in the database.");
        log.info("\nlista: "+list.size());
        return list.isEmpty();
    }
}
