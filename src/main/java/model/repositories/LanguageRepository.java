package model.repositories;

import model.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Language> S save(@NonNull S entity);

    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Language> List<S> saveAll(@NonNull Iterable<S> entities);

    List<Language> findByName(String name);
    List<Language> findByIdIn(List<Long> ids);
}