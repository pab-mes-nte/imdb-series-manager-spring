package com.example.model.repositories;

import com.example.model.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Actor> S save(@NonNull S entity);

    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Actor> List<S> saveAll(@NonNull Iterable<S> entities);

    Actor findByName(String name);
    List<Actor> findByIdIn(List<Long> ids);
}