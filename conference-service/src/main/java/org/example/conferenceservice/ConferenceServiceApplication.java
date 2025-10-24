package org.example.conferenceservice;

import org.example.conferenceservice.entities.Conference;
import org.example.conferenceservice.entities.Review;
import org.example.conferenceservice.repository.ConferenceRepository;
import org.example.conferenceservice.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ConferenceRepository conferenceRepository,
                                        ReviewRepository reviewRepository) {
        return args -> {
            // === Création des conférences ===
            Conference c1 = conferenceRepository.save(Conference.builder()
                    .titre("abc")
                    .type("academique")
                    .date("01/03/2024")
                    .duree("2h")
                    .nbrinscrit(50)
                    .score(100)
                    .build());

            Conference c2 = conferenceRepository.save(Conference.builder()
                    .titre("simple faire")
                    .type("commercial")
                    .date("02/05/2025")
                    .duree("1h")
                    .nbrinscrit(70)
                    .score(300)
                    .build());

            Conference c3 = conferenceRepository.save(Conference.builder()
                    .titre("cyber security")
                    .type("academique")
                    .date("05/03/2025")
                    .duree("3h")
                    .nbrinscrit(200)
                    .score(100)
                    .build());

            // === Ajout de reviews associées ===
            reviewRepository.saveAll(List.of(
                    Review.builder()
                            .date("2024-03-02")
                            .text("Super conférence académique")
                            .note(5)
                            .conference(c1)
                            .build(),
                    Review.builder()
                            .date("2025-05-03")
                            .text("Intéressante mais trop courte")
                            .note(3)
                            .conference(c2)
                            .build(),
                    Review.builder()
                            .date("2025-03-06")
                            .text("Excellent contenu sur la cybersécurité !")
                            .note(5)
                            .conference(c3)
                            .build()
            ));

            System.out.println("✅ Données initiales chargées avec succès !");
        };
    }
}
