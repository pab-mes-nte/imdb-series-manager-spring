package com.example.model.repositories;

import com.example.model.entities.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Series> S save(@NonNull S entity);

    @Override
    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Series> List<S> saveAll(@NonNull Iterable<S> entities);

    List<Series> findByName(String name);
    List<Series> findByIdIn(List<Long> ids);

    // Selects the series that contain the given string in any of its attributes
    @Query("SELECT s FROM Series s WHERE LOWER(CONCAT(COALESCE(s.name, ''), ' ', COALESCE(s.rated, ''), ' ', COALESCE(s.released, ''), ' ', COALESCE(s.plot, '')," +
            " ' ', COALESCE(s.awards, ''), ' ', COALESCE(s.poster, ''), ' ', COALESCE(s.metascore, ''), ' ', COALESCE(s.imbdRating, ''), ' ', COALESCE(s.imdbVotes, '')," +
            " ' ', COALESCE(s.totalSeasons, ''))) LIKE LOWER(CONCAT('%', :str, '%'))")
    List<Series> findByAllAttributesContainingIgnoreCase(@Param("str") String str);
}