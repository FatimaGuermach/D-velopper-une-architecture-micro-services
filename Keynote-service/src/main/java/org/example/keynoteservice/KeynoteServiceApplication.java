package org.example.keynoteservice;

import lombok.Builder;
import org.example.keynoteservice.entities.Keynote;
import org.example.keynoteservice.repository.Keynoterepositpry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);

    }
    @Bean
    CommandLineRunner commandLineRunner(Keynoterepositpry keynoterepositpry) {
        return args -> {
            keynoterepositpry.save(Keynote.builder()
                    .nom("GUERMACH")
                    .prenom("FATIMA")
                    .email("fatima@gmail.com")
                    .fonction("etudiante")
                    .build());

            keynoterepositpry.save(Keynote.builder()
                    .nom("mohammed")
                    .prenom("moh")
                    .email("moh@gmail.com")
                    .fonction("doctorant")
                    .build());

            keynoterepositpry.save(Keynote.builder()
                    .nom("Guerm")
                    .prenom("hiba")
                    .email("hiba@gmail.com")
                    .fonction("professeure")
                    .build());
        };
    }


}
