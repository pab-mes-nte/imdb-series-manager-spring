package com.example.model.repositories;

import com.example.model.entities.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WriterRepository extends JpaRepository<Writer, Long> {
    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Writer> S save(@NonNull S entity);

    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Writer> List<S> saveAll(@NonNull Iterable<S> entities);

    List<Writer> findByName(String name);
    List<Writer> findByIdIn(List<Long> ids);
}