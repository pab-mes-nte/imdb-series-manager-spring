package view;

import controller.SeriesRepository;
import model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("model")
@EnableJpaRepositories(basePackages = "controller")
public class Main implements CommandLineRunner {
    private final SeriesRepository seriesrep;

    @Autowired
    public Main(final SeriesRepository seriesrep) {
        this.seriesrep = seriesrep;
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Series serie1 = new Series();
        serie1.setName("Fallout");

        seriesrep.save(serie1);
    }
}