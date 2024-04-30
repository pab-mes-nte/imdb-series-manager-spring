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
    @Column(name = "released")
    @Temporal(TemporalType.DATE)
    private LocalDate released;
    @Column(name = "plot")
    private String plot;
    @Column(name = "awards")
    private String awards;
    @Column(name = "poster")
    private String poster;
    // Out of 100
    @Column(name = "metascore")
    private int metascore;
    // Out of 100
    @Column(name = "imbd_rating")
    private int imbdRating;
    @Column(name = "imdb_votes")
    private int imdbVotes;
    @Column(name = "total_seasons")
    private int totalSeasons;

    // Series has the join tables, so it becomes the owner of the join tables
    // Series -> Actor
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "actor_series", joinColumns = @JoinColumn(name = "series_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actorsList;
    // Series -> Country
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "country_series", joinColumns = @JoinColumn(name = "series_id"), inverseJoinColumns = @JoinColumn(name = "country_id"))
    private List<Country> countriesList;
    // Series -> Category
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "category_series", joinColumns = @JoinColumn(name = "series_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categoriesList;
    // Series -> Director
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "director_series", joinColumns = @JoinColumn(name = "series_id"), inverseJoinColumns = @JoinColumn(name = "director_id"))
    private List<Director> directorsList;
    // Series -> Language
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "language_series", joinColumns = @JoinColumn(name = "series_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languagesList;
    // Series -> Writer
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "writer_series", joinColumns = @JoinColumn(name = "series_id"), inverseJoinColumns = @JoinColumn(name = "writer_id"))
    private List<Writer> writersList;

    // The Many of a One to Many can't be the owner of the relation
    // Series -> Rating
    @OneToMany(mappedBy = "series", cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Rating> ratingsList;


    public Series() {
        // Required empty constructor
    }

    public Series(String name, String rated, LocalDate released, String plot, String awards, String poster, int metascore, int imbdRating, int imdbVotes, int totalSeasons) {
        this.name = name;
        this.rated = rated;
        this.released = released;
        this.plot = plot;
        this.awards = awards;
        this.poster = poster;
        this.metascore = metascore;
        this.imbdRating = imbdRating;
        this.imdbVotes = imdbVotes;
        this.totalSeasons = totalSeasons;
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

    public void addActor(Actor actor) {
        this.actorsList.add(actor);
    }

    public List<Country> getCountriesList() {
        return countriesList;
    }

    public void setCountriesList(List<Country> countriesList) {
        this.countriesList = countriesList;
    }

    public void addCountry(Country country) {
        this.countriesList.add(country);
    }

    public List<Category> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public void addCategory(Category category) {
        this.categoriesList.add(category);
    }

    public List<Director> getDirectorsList() {
        return directorsList;
    }

    public void setDirectorsList(List<Director> directorsList) {
        this.directorsList = directorsList;
    }

    public void addDirector(Director director) {
        this.directorsList.add(director);
    }

    public List<Language> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(List<Language> languagesList) {
        this.languagesList = languagesList;
    }

    public void addLanguage(Language language) {
        this.languagesList.add(language);
    }

    public List<Writer> getWritersList() {
        return writersList;
    }

    public void setWritersList(List<Writer> writersList) {
        this.writersList = writersList;
    }

    public void addWriter(Writer writer) {
        this.writersList.add(writer);
    }

    public List<Rating> getRatingsList() {
        return ratingsList;
    }

    public void setRatingsList(List<Rating> ratingsList) {
        this.ratingsList = ratingsList;
    }

    public void addRating(Rating rating) {
        this.ratingsList.add(rating);
    }

    @Override
    public String toString() {
        return "Series{" + "name='" + name + '\'' + ", rated='" + rated + '\'' + ", released=" + released + ", plot='" + plot + '\'' + ", awards='" + awards + '\'' + ", poster='" + poster + '\'' + ", metascore=" + metascore + ", imbdRating=" + imbdRating + ", imdbVotes=" + imdbVotes + ", totalSeasons=" + totalSeasons + '}';
    }
}