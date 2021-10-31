package com.br.java.carteiradigital.repository;

import com.br.java.carteiradigital.model.Entry;
import com.br.java.carteiradigital.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EntryRepository {

    Entry findByIdAndUserId(Long id, Long userId);

    List<Entry> findAllByUserId(Long userId, Pageable pageable);

    List<Entry> findAllByCategory(String category, User userId, Pageable pageable);

    List<Entry> findAllByAmountGreaterThan(BigDecimal amount, User userId, Pageable pageable);

    List<Entry> findAllByAmountLowerThan(BigDecimal amount, User userId, Pageable pageable);

}
