package com.br.java.carteiradigital.repository;

import com.br.java.carteiradigital.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.firstname = :firstname AND u.lastname = :lastname")
    List<User> findAllByFullName(@Param("firstname") String firstname, @Param("lastname")String lastname, Pageable pageable);

    List<User> findAllByFirstname(String firstName, Pageable pageable);

    List<User> findAllByLastname(String lastname, Pageable pageable);

    User findByEmail(String email);

}
