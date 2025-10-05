package com.k48.Gestion.des.taches.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;



@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tache")
public class Tache extends AbstractEntity {

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
