package org.example.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Conference {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String type;
    private String date;
    private String duree;
    private  int nbrinscrit;
    private  int score;
    @OneToMany(mappedBy = "conference",cascade = CascadeType.ALL)
    private List<Review> reviews;

}
