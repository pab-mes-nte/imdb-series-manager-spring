package com.example.util;

import com.example.model.repositories.*;
import com.example.model.entities.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class SeriesRandomizer {
    // Data
    SeriesRandData data = new SeriesRandData();

    // TODO: Remove Unused Repositories
    private final SeriesRepository seriesRep;
    private final ActorRepository actorRep;
    private final CategoryRepository categoryRep;
    private final CountryRepository countryRep;
    private final DirectorRepository directorRep;
    private final LanguageRepository languageRep;
    private final RatingRepository ratingRep;
    private final SeriesLogRepository logRep;
    private final WriterRepository writerRep;

    public SeriesRandomizer(SeriesRepository seriesRep, ActorRepository actorRep, CategoryRepository categoryRep, CountryRepository countryRep, DirectorRepository directorRep, LanguageRepository languageRep, RatingRepository ratingRep, SeriesLogRepository logRep, WriterRepository writerRep) {
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

    public void randomize() {
        // Insert of all actors
        for (String name : data.actors) {
            actorRep.save(new Actor(name));
        }

        // Insert of all categories
        for (String name : data.categories) {
            categoryRep.save(new Category(name));
        }

        // Insert of all countries
        for (String name : data.countries) {
            countryRep.save(new Country(name));
        }

        // Insert of all directors
        for (String name : data.directors) {
            directorRep.save(new Director(name));
        }

        // Insert of all languages
        for (String name : data.languages) {
            languageRep.save(new Language(name));
        }

        // Insert of all writers
        for (String name : data.writers) {
            writerRep.save(new Writer(name));
        }

        // Insert of all series
        Random r = new Random();
        
        for (String s : data.series) {
            Series series = new Series(s, data.contentRatings[r.nextInt(data.contentRatings.length)], LocalDate.of(r.nextInt(124) + 1900, r.nextInt(12) + 1, r.nextInt(28) + 1), "I'm not going to randomize a plot. Generated by M.", "Same for the awards, I'm too lazy.", null, r.nextInt(100) + 1, r.nextInt(100) + 1, r.nextInt(1000000), r.nextInt(10) + 1);

            // Randomized number of child objects
            int n;
            Long[] chIndex;

            // Actors
            n = r.nextInt(4);
            chIndex = new Long[n];
            for (int i = 0; i < n; i++) {
                chIndex[i] = (long) (r.nextInt(data.actors.length) + 1);
            }
            series.setActorsList(actorRep.findByIdIn(Arrays.asList(chIndex)));

            // Categories
            n = r.nextInt(4);
            chIndex = new Long[n];
            for (int i = 0; i < n; i++) {
                chIndex[i] = (long) (r.nextInt(data.categories.length) + 1);
            }
            series.setCategoriesList(categoryRep.findByIdIn(Arrays.asList(chIndex)));

            // Countries
            n = r.nextInt(4);
            chIndex = new Long[n];
            for (int i = 0; i < n; i++) {
                chIndex[i] = (long) (r.nextInt(data.countries.length) + 1);
            }
            series.setCountriesList(countryRep.findByIdIn(Arrays.asList(chIndex)));

            // Directors
            n = r.nextInt(4);
            chIndex = new Long[n];
            for (int i = 0; i < n; i++) {
                chIndex[i] = (long) (r.nextInt(data.directors.length) + 1);
            }
            series.setDirectorsList(directorRep.findByIdIn(Arrays.asList(chIndex)));

            // Languages
            n = r.nextInt(4);
            chIndex = new Long[n];
            for (int i = 0; i < n; i++) {
                chIndex[i] = (long) (r.nextInt(data.languages.length) + 1);
            }
            series.setLanguagesList(languageRep.findByIdIn(Arrays.asList(chIndex)));

            // Writers
            n = r.nextInt(4);
            chIndex = new Long[n];
            for (int i = 0; i < n; i++) {
                chIndex[i] = (long) (r.nextInt(data.writers.length) + 1);
            }
            series.setWritersList(writerRep.findByIdIn(Arrays.asList(chIndex)));

            seriesRep.save(series);
        }
    }
}
