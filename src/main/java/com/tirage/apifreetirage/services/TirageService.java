package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.modele.Tirage;

import java.util.List;

public interface TirageService {

    //methode permettant de faire le trie avec la liste des postulant à trie et le nombre à trié en parametre
    List<Postulant> trie(List<Postulant> listAtrier, Long nbre);

    //methode permettant de creer un tirage
    Tirage creer(Tirage tirage, Liste liste);

    //methode permettant de trouver un tirage par son libellet
    Tirage trouverTirageParLibelle(String libellet);

    List<Tirage> lire();
}
