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
import java.util.Objects;

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
                // If the child's name is not null
                if (actor.getName() != null) {
                    // Searches for the child name
                    Actor existingActor = actorRep.findByName(actor.getName());
                    // Adds the child if it doesn't exist
                    actorsList.add(Objects.requireNonNullElse(existingActor, actor));
                }
            }
            series.setActorsList(actorsList);
        }

        if (series.getCategoriesList() != null) {
            // Checks the children are unique, creating a relation with the existing ones if not
            ArrayList<Category> categoriesList = new ArrayList<>();
            for (Category category : series.getCategoriesList()) {
                // If the child's name is not null
                if (category.getName() != null) {
                    // Searches for the child name
                    Category existingCategory = categoryRep.findByName(category.getName());
                    // Adds the child if it doesn't exist
                    categoriesList.add(Objects.requireNonNullElse(existingCategory, category));
                }
            }
            series.setCategoriesList(categoriesList);
        }

        if (series.getCountriesList() != null) {
            // Checks the children are unique, creating a relation with the existing ones if not
            ArrayList<Country> countriesList = new ArrayList<>();
            for (Country country : series.getCountriesList()) {
                // If the child's name is not null
                if (country.getName() != null) {
                    // Searches for the child name
                    Country existingCountry = countryRep.findByName(country.getName());
                    // Adds the child if it doesn't exist
                    countriesList.add(Objects.requireNonNullElse(existingCountry, country));
                }
            }
            series.setCountriesList(countriesList);
        }

        if (series.getDirectorsList() != null) {
            // Checks the children are unique, creating a relation with the existing ones if not
            ArrayList<Director> directorsList = new ArrayList<>();
            for (Director director : series.getDirectorsList()) {
                // If the child's name is not null
                if (director.getName() != null) {
                    // Searches for the child name
                    Director existingDirector = directorRep.findByName(director.getName());
                    // Adds the child if it doesn't exist
                    directorsList.add(Objects.requireNonNullElse(existingDirector, director));
                }
            }
            series.setDirectorsList(directorsList);
        }

        if (series.getLanguagesList() != null) {
            // Checks the children are unique, creating a relation with the existing ones if not
            ArrayList<Language> languagesList = new ArrayList<>();
            for (Language language : series.getLanguagesList()) {
                // If the child's name is not null
                if (language.getName() != null) {
                    // Searches for the child name
                    Language existingLanguage = languageRep.findByName(language.getName());
                    // Adds the child if it doesn't exist
                    languagesList.add(Objects.requireNonNullElse(existingLanguage, language));
                }
            }
            series.setLanguagesList(languagesList);
        }

        if (series.getWritersList() != null) {
            // Checks the children are unique, creating a relation with the existing ones if not
            ArrayList<Writer> writersList = new ArrayList<>();
            for (Writer writer : series.getWritersList()) {
                // If the child's name is not null
                if (writer.getName() != null) {
                    // Searches for the child name
                    Writer existingWriter = writerRep.findByName(writer.getName());
                    // Adds the child if it doesn't exist
                    writersList.add(Objects.requireNonNullElse(existingWriter, writer));
                }
            }
            series.setWritersList(writersList);
        }
    }

    @After("insIntoSeries()")
    public void insertedSeries() {
        logger.info("Success!");
    }
}