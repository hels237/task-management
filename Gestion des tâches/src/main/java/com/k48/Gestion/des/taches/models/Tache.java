package com.k48.Gestion.des.taches.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tache")

public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String description;
    private String responsable;
    private LocalDate dateCreation;
    private LocalDate dateEcheance;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;


}
