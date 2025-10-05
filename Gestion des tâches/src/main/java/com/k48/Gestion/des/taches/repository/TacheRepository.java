package com.k48.Gestion.des.taches.repository;

import com.k48.Gestion.des.taches.models.Statut;
import com.k48.Gestion.des.taches.models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TacheRepository extends JpaRepository<Tache, Long> {

    List<Tache> findByStatut(Statut statut);
    Optional<Tache> findByTitreAndDescription(String titre, String description);

    void deleteById(Long id);


}
