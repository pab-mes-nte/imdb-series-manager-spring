package model.repositories;

import model.entities.SeriesLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesLogRepository extends JpaRepository<SeriesLog, Long> {

}