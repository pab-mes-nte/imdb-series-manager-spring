package model.repositories;

import model.entities.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WriterRepository extends JpaRepository<Writer, Long> {
    List<Writer> findByName(String name);
}