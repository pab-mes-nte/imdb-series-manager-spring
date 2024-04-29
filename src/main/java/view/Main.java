package view;

import controller.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EntityScan("model")
@EnableJpaRepositories(basePackages = "controller")
public class Main implements CommandLineRunner {
    private final SeriesRepository seriesRep;
    private final ActorRepository actorRep;
    private final CategoryRepository categoryRep;
    private final CountryRepository countryRep;
    private final DirectorRepository directorRep;
    private final LanguageRepository languageRep;
    private final RatingsRepository ratingsRep;
    private final SeriesLogRepository logRep;
    private final WriterRepository writerRep;

    @Autowired
    public Main(final SeriesRepository seriesRep, ActorRepository actorRep, CategoryRepository categoryRep, CountryRepository countryRep, DirectorRepository directorRep, LanguageRepository languageRep, RatingsRepository ratingsRep, SeriesLogRepository logRep, WriterRepository writerRep) {
        this.seriesRep = seriesRep;
        this.actorRep = actorRep;
        this.categoryRep = categoryRep;
        this.countryRep = countryRep;
        this.directorRep = directorRep;
        this.languageRep = languageRep;
        this.ratingsRep = ratingsRep;
        this.logRep = logRep;
        this.writerRep = writerRep;
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        // Serie example
        Series serie1 = new Series();
        serie1.setName("Fallout");
        serie1.setRated("TV-MA");
        serie1.setPoster("https://m.media-amazon.com/images/M/MV5BN2EwNjFhMmEtZDc4YS00OTUwLTkyODEtMzViMzliZWIyMzYxXkEyXkFqcGdeQXVyMjkwOTAyMDU@._V1_SX300.jpg");
        serie1.setPlot("In a future, post-apocalyptic Los Angeles brought about by nuclear decimation, citizens must live in underground bunkers to protect themselves from radiation, mutants and bandits.");
        serie1.setImbdRating(87);
        serie1.setImdbVotes(40394);
        serie1.setTotalSeasons(1);
        serie1.setReleased(LocalDate.of(2024, 4, 10));

        // Categories (Genres)
        Category cat1 = new Category();
        cat1.setName("Action");
        Category cat2 = new Category();
        cat2.setName("Adventure");
        Category cat3 = new Category();
        cat3.setName("Drama");
        serie1.setCategories(List.of(cat1, cat2, cat3));

        // Writers
        Writer writer1 = new Writer();
        writer1.setName("Geneva Robertson-Dworet");
        Writer writer2 = new Writer();
        writer2.setName("Graham Wagner");
        serie1.setWriters(List.of(writer1, writer2));

        // Actors
        Actor actor1 = new Actor();
        actor1.setName("Ella Purnell");
        Actor actor2 = new Actor();
        actor2.setName("Aaron Moten");
        Actor actor3 = new Actor();
        actor3.setName("Walton Goggins");
        serie1.setActors(List.of(actor1, actor2, actor3));

        // Languages
        Language lang1 = new Language();
        lang1.setName("English");
        serie1.setLanguages(List.of(lang1));

        // Countries
        Country country1 = new Country();
        country1.setName("United States");
        serie1.setCountries(List.of(country1));

        // Ratings
        Ratings rating1 = new Ratings();
        rating1.setName("Internet Movie Database");
        rating1.setValueRating(87);
        serie1.setRatings(List.of(rating1));

        // Data Recording
        categoryRep.saveAll(List.of(cat1, cat2, cat3));
        writerRep.saveAll(List.of(writer1, writer2));
        actorRep.saveAll(List.of(actor1, actor2, actor3));
        languageRep.saveAll(List.of(lang1));
        countryRep.saveAll(List.of(country1));
        ratingsRep.save(rating1);
        seriesRep.save(serie1);
    }
}