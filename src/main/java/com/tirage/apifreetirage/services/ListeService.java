package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Liste;

public interface ListeService {

    Liste creer(Liste liste);
    Liste trouverListeParLibelle(String libelle);
    int ajouterIdListe(Long idList);
}
