package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.SeriesService;

@RestController
@RequestMapping("/api")
public class SeriesController {
    // Logger
    private static final Logger logger = LogManager.getLogger("SeriesController");

    // Services
    private final SeriesService seriesService;

    @Autowired
    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/series")
    public String getSeries(@RequestParam(name = "name") String name) {
        logger.info("Containing:{} ", name);

        return "Hallo";
    }
}