package com.example.model.repositories;

import com.example.model.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Director> S save(@NonNull S entity);

    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Director> List<S> saveAll(@NonNull Iterable<S> entities);

    List<Director> findByName(String name);
    List<Director> findByIdIn(List<Long> ids);
}