package com.k48.Gestion.des.taches.service;


import com.k48.Gestion.des.taches.models.Statut;
import com.k48.Gestion.des.taches.models.Tache;

import java.util.List;
import java.util.Optional;

public interface TacheService {

    Tache creerTache(Tache tache);

    Tache lireParId(Long id);

    List<Tache> lireToutesLesTache();

    List<Tache> lireTachesParStatut(Statut statut);

    Optional<Tache> modifierTache(Long id, Tache tache);

    void supprimerTache(Long id);

}
