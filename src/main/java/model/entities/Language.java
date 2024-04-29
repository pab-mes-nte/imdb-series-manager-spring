package model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "language")
public class Language implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // Language -> Series
    @ManyToMany(mappedBy = "languagesList")
    private List<Serie> seriesList;

    public Language() {
        // Required empty constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Serie> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<Serie> seriesList) {
        this.seriesList = seriesList;
    }
}
