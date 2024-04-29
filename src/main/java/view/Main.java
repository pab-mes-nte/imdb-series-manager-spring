package view;

import model.entities.*;
import model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EntityScan("model.entities")
@EnableJpaRepositories(basePackages = "model.repositories")
public class Main implements CommandLineRunner {
    // Repositories
    private final SeriesRepository seriesRep;
    private final ActorRepository actorRep;
    private final CategoryRepository categoryRep;
    private final CountryRepository countryRep;
    private final DirectorRepository directorRep;
    private final LanguageRepository languageRep;
    private final RatingRepository ratingRep;
    private final SeriesLogRepository logRep;
    private final WriterRepository writerRep;

    @Autowired
    public Main(final SeriesRepository seriesRep, ActorRepository actorRep, CategoryRepository categoryRep, CountryRepository countryRep, DirectorRepository directorRep, LanguageRepository languageRep, RatingRepository ratingRep, SeriesLogRepository logRep, WriterRepository writerRep) {
        this.seriesRep = seriesRep;
        this.actorRep = actorRep;
        this.categoryRep = categoryRep;
        this.countryRep = countryRep;
        this.directorRep = directorRep;
        this.languageRep = languageRep;
        this.ratingRep = ratingRep;
        this.logRep = logRep;
        this.writerRep = writerRep;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        // Series insertion example
        Series series1 = new Series();
        series1.setName("Fallout");
        series1.setRated("TV-MA");
        series1.setPoster("https://m.media-amazon.com/images/M/MV5BN2EwNjFhMmEtZDc4YS00OTUwLTkyODEtMzViMzliZWIyMzYxXkEyXkFqcGdeQXVyMjkwOTAyMDU@._V1_SX300.jpg");
        series1.setPlot("In a future, post-apocalyptic Los Angeles brought about by nuclear decimation, citizens must live in underground bunkers to protect themselves from radiation, mutants and bandits.");
        series1.setImbdRating(87);
        series1.setImdbVotes(40394);
        series1.setTotalSeasons(1);
        series1.setReleased(LocalDate.of(2024, 4, 10));

        // Categories (Genres)
        Category cat1 = new Category();
        cat1.setName("Action");
        Category cat2 = new Category();
        cat2.setName("Adventure");
        Category cat3 = new Category();
        cat3.setName("Drama");
        series1.setCategoriesList(List.of(cat1, cat2, cat3));

        // Writers
        Writer writer1 = new Writer();
        writer1.setName("Geneva Robertson-Dworet");
        Writer writer2 = new Writer();
        writer2.setName("Graham Wagner");
        series1.setWritersList(List.of(writer1, writer2));

        // Actors
        Actor actor1 = new Actor();
        actor1.setName("Ella Purnell");
        Actor actor2 = new Actor();
        actor2.setName("Aaron Moten");
        Actor actor3 = new Actor();
        actor3.setName("Walton Goggins");
        series1.setActorsList(List.of(actor1, actor2, actor3));

        // Languages
        Language lang1 = new Language();
        lang1.setName("English");
        series1.setLanguagesList(List.of(lang1));

        // Countries
        Country country1 = new Country();
        country1.setName("United States");
        series1.setCountriesList(List.of(country1));

        // Adding a Rating
        Rating rating1 = new Rating();
        rating1.setSource("Internet Movie Database");
        rating1.setValue(87);
        rating1.setSeries(series1);
        series1.setRatingsList(List.of(rating1));

        // Data Recording
        // Saving a rating propagates the insert operation to its child objects (series1), which also propagates the insert operation to the grandchild objects (actors, writers...)
        ratingRep.save(rating1);


        // Testing of getting data from the db
        Optional<Series> seriesTest = seriesRep.findById(1L);
        seriesTest.ifPresent(System.out::println);
        System.out.println(actorRep.findByName("Aaron Moten").getFirst().getName());
    }
}