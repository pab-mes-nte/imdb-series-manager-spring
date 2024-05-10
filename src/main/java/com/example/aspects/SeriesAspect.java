package com.example.aspects;

import com.example.model.entities.*;
import com.example.model.repositories.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Aspect
public class SeriesAspect {
    // Logger
    private static final Logger logger = LogManager.getLogger("SeriesAspect");

    // Repositories
    private final ActorRepository actorRep;
    private final CategoryRepository categoryRep;
    private final CountryRepository countryRep;
    private final DirectorRepository directorRep;
    private final LanguageRepository languageRep;
    private final WriterRepository writerRep;

    @Autowired
    public SeriesAspect(ActorRepository actorRep, CategoryRepository categoryRep, CountryRepository countryRep, DirectorRepository directorRep, LanguageRepository languageRep, WriterRepository writerRep) {
        this.actorRep = actorRep;
        this.categoryRep = categoryRep;
        this.countryRep = countryRep;
        this.directorRep = directorRep;
        this.languageRep = languageRep;
        this.writerRep = writerRep;
    }

    @Pointcut("execution(* com.example.model.repositories.SeriesRepository.save(..))")
    public void insIntoSeries() {
    }

    @Before("insIntoSeries()")
    public void duplicateRemovalBeforeSeriesIns(JoinPoint jP) {
        // Receives the series to be inserted
        Series series = (Series) jP.getArgs()[0];

        // If the ID is null, it's an insert, if not, it's an update (or at least it should be like that)
        if (series.getId() == null) {
            logger.info("Inserting series '{}'...", series.getName());
        } else {
            logger.info("Updating series '{}', with ID={}...", series.getName(), series.getId());
        }

        // Checks the children are unique, creating a relation with the existing ones if not
        if (series.getActorsList() != null) {
            ArrayList<Actor> actorsList = new ArrayList<>();
            for (Actor actor : series.getActorsList()) {
                // If the child does not exist in the DB
                if (actor.getName() != null && actorRep.findByName(actor.getName()) == null) {
                    // Insert it
                    actorRep.save(new Actor(actor.getName()));
                }
                // Searches for the child's name and adds it to the new list
                actorsList.add(actorRep.findByName(actor.getName()));
            }
            series.setActorsList(actorsList);
        }

        if (series.getCategoriesList() != null) {
            // Checks the children are unique, creating a relation with the existing ones if not
            ArrayList<Category> categoriesList = new ArrayList<>();
            for (Category category : series.getCategoriesList()) {
                // If the child does not exist in the DB
                if (category.getName() != null && categoryRep.findByName(category.getName()) == null) {
                    // Insert it
                    categoryRep.save(new Category(category.getName()));
                }
                // Searches for the child's name and adds it to the new list
                categoriesList.add(categoryRep.findByName(category.getName()));
            }
            series.setCategoriesList(categoriesList);
        }

        if (series.getCountriesList() != null) {
            // Checks the children are unique, creating a relation with the existing ones if not
            ArrayList<Country> countriesList = new ArrayList<>();
            for (Country country : series.getCountriesList()) {
                // If the child does not exist in the DB
                if (country.getName() != null && countryRep.findByName(country.getName()) == null) {
                    // Insert it
                    countryRep.save(new Country(country.getName()));
                }
                // Searches for the child's name and adds it to the new list
                countriesList.add(countryRep.findByName(country.getName()));
            }
            series.setCountriesList(countriesList);
        }

        if (series.getDirectorsList() != null) {
            // Checks the children are unique, creating a relation with the existing ones if not
            ArrayList<Director> directorsList = new ArrayList<>();
            for (Director director : series.getDirectorsList()) {
                // If the child does not exist in the DB
                if (director.getName() != null && directorRep.findByName(director.getName()) == null) {
                    // Insert it
                    directorRep.save(new Director(director.getName()));
                }
                // Searches for the child's name and adds it to the new list
                directorsList.add(directorRep.findByName(director.getName()));
            }
            series.setDirectorsList(directorsList);
        }

        if (series.getLanguagesList() != null) {
            // Checks the children are unique, creating a relation with the existing ones if not
            ArrayList<Language> languagesList = new ArrayList<>();
            for (Language language : series.getLanguagesList()) {
                // If the child does not exist in the DB
                if (language.getName() != null && languageRep.findByName(language.getName()) == null) {
                    // Insert it
                    languageRep.save(new Language(language.getName()));
                }
                // Searches for the child's name and adds it to the new list
                languagesList.add(languageRep.findByName(language.getName()));
            }
            series.setLanguagesList(languagesList);
        }

        if (series.getWritersList() != null) {
            // Checks the children are unique, creating a relation with the existing ones if not
            ArrayList<Writer> writersList = new ArrayList<>();
            for (Writer writer : series.getWritersList()) {
                // If the child does not exist in the DB
                if (writer.getName() != null && writerRep.findByName(writer.getName()) == null) {
                    // Insert it
                    writerRep.save(new Writer(writer.getName()));
                }
                // Searches for the child's name and adds it to the new list
                writersList.add(writerRep.findByName(writer.getName()));
            }
            series.setWritersList(writersList);
        }
    }

    @After("insIntoSeries()")
    public void insertedSeries(JoinPoint jP) {
        // Receives inserted series
        Series series = (Series) jP.getArgs()[0];
        logger.info("Series '{}' insert successful!", series.getName());
    }
}