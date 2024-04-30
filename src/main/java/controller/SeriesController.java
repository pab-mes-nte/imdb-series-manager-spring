package controller;

import model.entities.Series;
import model.repositories.SeriesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SeriesController {
    // Logger
    private static final Logger logger = LogManager.getLogger("SeriesController");

    // Repositories
    private final SeriesRepository seriesRep;

    public SeriesController(SeriesRepository seriesRep) {
        this.seriesRep = seriesRep;
    }

    @GetMapping("/series")
    public String getSeries(@RequestParam(name = "name") String name) {
        logger.info("Containing:{} ", name);
        List<Series> series = seriesRep.findByAllAttributesContainingIgnoreCase(name);
        StringBuilder ret = new StringBuilder();
        int nResult = 0;
        for (Series s : series) {
            ret.append(s.toString()).append("\n");
            nResult++;
        }
        logger.info("Total results:{} ", nResult);

        return ret.toString();
    }
}