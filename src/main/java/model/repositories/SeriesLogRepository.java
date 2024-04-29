package model.repositories;

import model.entities.SeriesLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriesLogRepository extends JpaRepository<SeriesLog, Long> {
    List<SeriesLog> findAllByOrderByIdDesc();
    List<SeriesLog> findTop10ByOrderByIdDesc();

}