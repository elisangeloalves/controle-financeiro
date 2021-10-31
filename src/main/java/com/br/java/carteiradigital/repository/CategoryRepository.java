package com.br.java.carteiradigital.repository;

import com.br.java.carteiradigital.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository {

    Category findByName(String name);

}
