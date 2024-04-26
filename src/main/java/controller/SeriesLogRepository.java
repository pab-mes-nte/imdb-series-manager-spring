package controller;

import model.SeriesLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesLogRepository extends JpaRepository<SeriesLog, Integer> {
}