package com.example.model.repositories;

import com.example.model.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Rating> S save(@NonNull S entity);

    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Rating> List<S> saveAll(@NonNull Iterable<S> entities);

    List<Rating> findBySource(String source);
    List<Rating> findByIdIn(List<Long> ids);
}