package com.k48.Gestion.des.taches.controller;


import com.k48.Gestion.des.taches.dto.TacheDto;
import com.k48.Gestion.des.taches.mapper.TacheMapper;
import com.k48.Gestion.des.taches.models.Statut;
import com.k48.Gestion.des.taches.models.Tache;
import com.k48.Gestion.des.taches.service.TacheService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;



@RestController
@Tag(name = "Gestion des Tâches", description = "API pour la gestion des tâches")
@RequestMapping("/api/taches")
public class TacheController {

    private final TacheService tacheService;
    private final TacheMapper tacheMapper;

    //  Injection par constructeur
    public TacheController(TacheService tacheService, TacheMapper tacheMapper) {
        this.tacheService = tacheService;
        this.tacheMapper = tacheMapper;
    }


    @Operation(summary = "Créer une nouvelle tâche", 
               description = "Crée une nouvelle tâche avec les informations fournies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tâche créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "409", description = "Tâche déjà existante (doublon)")
    })
    @PostMapping
    public ResponseEntity<TacheDto> creerTache(@RequestBody TacheDto dto) {
        Tache tache = tacheMapper.toEntity(dto);
        Tache cree = tacheService.creerTache(tache);
        return ResponseEntity.ok(tacheMapper.toDTO(cree));
    }


    @Operation(summary = "Récupérer toutes les tâches", 
               description = "Retourne la liste complète de toutes les tâches")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des tâches récupérée avec succès")
    })
    @GetMapping
    public ResponseEntity<List<TacheDto>> lireToutesLesTaches() {
        return ResponseEntity.ok(
                tacheService.lireToutesLesTache().stream().map(tacheMapper::toDTO).toList()
        );
      }

    @Operation(summary = "Récupérer une tâche par ID", 
               description = "Retourne les détails d'une tâche spécifique")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tâche trouvée"),
            @ApiResponse(responseCode = "404", description = "Tâche non trouvée")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TacheDto> lireParId(
            @Parameter(description = "ID de la tâche", required = true) 
            @PathVariable Long id) {
        return ResponseEntity.ok(
                tacheMapper.toDTO(tacheService.lireParId(id))
        );
    }

      @Operation(summary = "Filtrer les tâches par statut", 
                 description = "Retourne toutes les tâches ayant le statut spécifié")
      @ApiResponses(value = {
              @ApiResponse(responseCode = "200", description = "Tâches filtrées avec succès")
      })
      @GetMapping("/statut/{statut}")
      public ResponseEntity<List<TacheDto>> lireTachesParStatut(
              @Parameter(description = "Statut des tâches (A_FAIRE, EN_COURS, TERMINEE)", required = true)
              @PathVariable Statut statut) {
          return ResponseEntity.ok(
                  tacheService.lireTachesParStatut(statut).stream().map(tacheMapper::toDTO).toList()
          );
      }



      @Operation(summary = "Modifier une tâche existante", 
                 description = "Met à jour les informations d'une tâche existante")
      @ApiResponses(value = {
              @ApiResponse(responseCode = "200", description = "Tâche modifiée avec succès"),
              @ApiResponse(responseCode = "404", description = "Tâche non trouvée"),
              @ApiResponse(responseCode = "400", description = "Données invalides")
      })
      @PutMapping("/{id}")
      public ResponseEntity<TacheDto> modifierTache(
              @Parameter(description = "ID de la tâche à modifier", required = true)
              @PathVariable Long id, 
              @RequestBody TacheDto dto) {
          Optional<Tache> modifie = tacheService.modifierTache(id, tacheMapper.toEntity(dto));
          return modifie.map(t -> ResponseEntity.ok(tacheMapper.toDTO(t)))
                  .orElseThrow(() -> new NoSuchElementException("Tâche non trouvée"));
      }


      @Operation(summary = "Supprimer une tâche", 
                 description = "Supprime définitivement une tâche")
      @ApiResponses(value = {
              @ApiResponse(responseCode = "204", description = "Tâche supprimée avec succès"),
              @ApiResponse(responseCode = "404", description = "Tâche non trouvée")
      })
      @DeleteMapping("/{id}")
      public ResponseEntity<Void> supprimerTache(
              @Parameter(description = "ID de la tâche à supprimer", required = true)
              @PathVariable Long id) {
          tacheService.supprimerTache(id);
          return ResponseEntity.noContent().build();
      }

}
