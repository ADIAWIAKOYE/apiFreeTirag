package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.modele.Tirage;

import java.util.List;

public interface TirageService {

    List<Postulant> trie(List<Postulant> listAtrier, Long nbre);

    Tirage creer(Tirage tirage, Liste liste);

    Tirage trouverTirageParLibelle(String libellet);
}
