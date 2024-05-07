package com.example.model.repositories;

import com.example.model.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Country> S save(@NonNull S entity);

    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Country> List<S> saveAll(@NonNull Iterable<S> entities);

    List<Country> findByName(String name);
    List<Country> findByIdIn(List<Long> ids);
}