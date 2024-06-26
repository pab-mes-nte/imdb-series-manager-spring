package com.example.util;

import com.example.model.entities.*;
import com.example.model.repositories.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {
    // Logger
    private static final Logger logger = LogManager.getLogger("DBInit");

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
    public DBInit(SeriesRepository seriesRep, ActorRepository actorRep, CategoryRepository categoryRep, CountryRepository countryRep, DirectorRepository directorRep, LanguageRepository languageRep, RatingRepository ratingRep, SeriesLogRepository logRep, WriterRepository writerRep) {
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

    @Override
    public void run(String... args) {
        if (seriesRep.count() == 0) {
            logger.info("No series found, inserting some...");

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
            cat1.setName("Action_Test");
            Category cat2 = new Category();
            cat2.setName("Adventure_Test");
            Category cat3 = new Category();
            cat3.setName("Drama_Test");
            categoryRep.saveAll(List.of(cat1, cat2, cat3));
            series1.setCategoriesList(List.of(cat1, cat2, cat3));

            // Writers
            Writer writer1 = new Writer();
            writer1.setName("Geneva Robertson-Dworet_Test");
            Writer writer2 = new Writer();
            writer2.setName("Graham Wagner_Test");
            writerRep.saveAll(List.of(writer1, writer2));
            series1.setWritersList(List.of(writer1, writer2));

            // Actors
            Actor actor1 = new Actor();
            actor1.setName("Ella Purnell_Test");
            Actor actor2 = new Actor();
            actor2.setName("Aaron Moten_Test");
            Actor actor3 = new Actor();
            actor3.setName("Walton Goggins_Test");
            actorRep.saveAll(List.of(actor1, actor2, actor3));
            series1.setActorsList(List.of(actor1, actor2, actor3));

            // Languages
            Language lang1 = new Language();
            lang1.setName("English_Test");
            languageRep.saveAll(List.of(lang1));
            series1.setLanguagesList(List.of(lang1));

            // Countries
            Country country1 = new Country();
            country1.setName("United States_Test");
            countryRep.saveAll(List.of(country1));
            series1.setCountriesList(List.of(country1));

            // Adding a Rating
            Rating rating1 = new Rating();
            rating1.setSource("Internet Movie Database");
            rating1.setValue(87);
            rating1.setSeries(series1);
            Rating rating2 = new Rating();
            rating2.setSource("Internet Movie Database");
            rating2.setValue(87);
            rating2.setSeries(series1);
            series1.setRatingsList(List.of(rating1, rating2));

            // Data Recording
            seriesRep.save(series1);
            ratingRep.saveAll(List.of(rating1, rating2));

            // Random Data
            SeriesRandomizer randomizer = new SeriesRandomizer(seriesRep, actorRep, categoryRep, countryRep, directorRep, languageRep, ratingRep, writerRep);
            randomizer.randomize();
        }

        SeriesLog log = new SeriesLog();
        log.setDescription("DB Initialized");
        logRep.save(log);

        logger.info("Complete!");
    }
}