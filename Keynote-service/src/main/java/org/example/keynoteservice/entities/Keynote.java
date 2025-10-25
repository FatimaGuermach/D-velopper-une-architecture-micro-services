package org.example.keynoteservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.web.servlet.view.groovy.GroovyMarkupView;

import java.util.Date;
@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Keynote {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String fonction;
    private String email;


}
