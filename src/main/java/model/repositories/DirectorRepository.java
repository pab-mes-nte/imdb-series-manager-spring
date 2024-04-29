package model.repositories;

import model.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    List<Director> findByName(String name);
}