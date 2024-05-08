package com.example.model.repositories;

import com.example.model.entities.SeriesLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// TODO: Give this use in aspects or whatever (or remove it)
public interface SeriesLogRepository extends JpaRepository<SeriesLog, Long> {
    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends SeriesLog> S save(@NonNull S entity);

    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends SeriesLog> List<S> saveAll(@NonNull Iterable<S> entities);

    List<SeriesLog> findAllByOrderByIdDesc();
    List<SeriesLog> findTop10ByOrderByIdDesc();
    List<SeriesLog> findByIdIn(List<Long> ids);

}