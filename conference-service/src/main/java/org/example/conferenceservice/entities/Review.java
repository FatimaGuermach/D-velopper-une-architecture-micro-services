package org.example.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor @Getter
@Setter @Builder
public class Review {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String text;
    private int note;
    @ManyToOne
    private Conference conference;
}
