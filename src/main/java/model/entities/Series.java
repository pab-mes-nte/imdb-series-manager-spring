package model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "series")
public class Series implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "rated")
    private String rated;
    @Column(name = "poster")
    private String poster;
    @Column(name = "plot")
    private String plot;
    @Column(name = "metascore")
    private int metascore;
    // TODO: Normalize Values of Ratings (out of 100, out of 10...)
    @Column(name = "imbd_rating")
    private int imbdRating;
    @Column(name = "imdb_votes")
    private int imdbVotes;
    @Column(name = "awards")
    private String awards;
    @Column(name = "total_seasons")
    private int totalSeasons;
    @Column(name = "released")
    private LocalDate released;
    
    // Serie has the join tables so it becomes the owner of the join tables
    // Serie -> Actor
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "actor_series", joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actorsList;
    // Serie -> Country
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "country_series", joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private List<Country> countriesList;
    // Serie -> Category
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "category_series", joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categoriesList;
    // Serie -> Director
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "director_series", joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id"))
    private List<Director> directorsList;
    // Serie -> Language
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "language_series", joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languagesList;
    // Serie -> Writer
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "writer_series", joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "writer_id"))
    private List<Writer> writersList;

    // The Many of a One to Many can't be the owner of the relation
    // Serie -> Rating
    @OneToMany(mappedBy = "serie")
    private List<Ratings> ratingsList;

    public Series() {
        // Required empty constructor
    }

    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rated='" + rated + '\'' +
                ", poster='" + poster + '\'' +
                ", plot='" + plot + '\'' +
                ", metascore=" + metascore +
                ", imbdRating=" + imbdRating +
                ", imdbVotes=" + imdbVotes +
                ", awards='" + awards + '\'' +
                ", totalSeasons=" + totalSeasons +
                ", released=" + released +
                ", actorsList=" + actorsList +
                ", countriesList=" + countriesList +
                ", categoriesList=" + categoriesList +
                ", directorsList=" + directorsList +
                ", languagesList=" + languagesList +
                ", writersList=" + writersList +
                ", ratingsList=" + ratingsList +
                '}';
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

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getMetascore() {
        return metascore;
    }

    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }

    public int getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(int imbdRating) {
        this.imbdRating = imbdRating;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(int totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public List<Actor> getActorsList() {
        return actorsList;
    }

    public void setActorsList(List<Actor> actorsList) {
        this.actorsList = actorsList;
    }

    public List<Country> getCountriesList() {
        return countriesList;
    }

    public void setCountriesList(List<Country> countriesList) {
        this.countriesList = countriesList;
    }

    public List<Category> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public List<Director> getDirectorsList() {
        return directorsList;
    }

    public void setDirectorsList(List<Director> directorsList) {
        this.directorsList = directorsList;
    }

    public List<Language> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(List<Language> languagesList) {
        this.languagesList = languagesList;
    }

    public List<Writer> getWritersList() {
        return writersList;
    }

    public void setWritersList(List<Writer> writersList) {
        this.writersList = writersList;
    }

    public List<Ratings> getRatingsList() {
        return ratingsList;
    }

    public void setRatingsList(List<Ratings> ratingsList) {
        this.ratingsList = ratingsList;
    }
}
