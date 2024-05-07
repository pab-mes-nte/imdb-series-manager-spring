package com.example.model.repositories;

import com.example.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Category> S save(@NonNull S entity);

    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Category> List<S> saveAll(@NonNull Iterable<S> entities);

    List<Category> findByName(String name);
    List<Category> findByIdIn(List<Long> ids);
}