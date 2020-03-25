package org.itadventure.covid;

import org.itadventure.covid.service.ScrappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class CovidDataServiceApplication implements CommandLineRunner {

    @Autowired
    private ScrappingService scrappingService;

    public static void main(String[] args) {
        SpringApplication.run(CovidDataServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //scrappingService.scrappingData();
    }

    @Scheduled(fixedRate = 60000) // 1 minutes
    public void taskExecutorService(){
        scrappingService.scrappingData();
    }
}
