package com.k48.Gestion.des.taches.dto;

import com.k48.Gestion.des.taches.models.Priorite;
import com.k48.Gestion.des.taches.models.Statut;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Objet de transfert de données pour une tâche")
public class TacheDto {
    
    @Schema(description = "Titre de la tâche", example = "Préparer la présentation", required = true)
    private String titre;
    
    @Schema(description = "Description détaillée de la tâche", 
            example = "Créer les slides pour la présentation client de la semaine prochaine")
    private String description;
    
    @Schema(description = "Statut actuel de la tâche", 
            allowableValues = {"A_FAIRE", "EN_COURS", "TERMINEE"}, 
            example = "EN_COURS")
    private Statut statut;
    
    @Schema(description = "Niveau de priorité de la tâche", 
            allowableValues = {"BASSE", "MOYENNE", "HAUTE"}, 
            example = "MOYENNE")
    private Priorite priorite;
    
    @Schema(description = "Nom du responsable de la tâche", example = "Alice")
    private String responsable;
    
    @Schema(description = "Date d'échéance de la tâche", 
            example = "2025-04-17", 
            type = "string", 
            format = "date")
    private LocalDate dateEcheance;
}
