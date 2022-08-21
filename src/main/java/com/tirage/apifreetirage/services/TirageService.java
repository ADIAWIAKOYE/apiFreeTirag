package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.modele.Tirage;

import java.util.List;

public interface TirageService {

    List<Postulant> creer(Tirage tirage, List<Postulant> listAtrier, Long nbre);

    Tirage trouverTirageParLibelle(String libellet);
}
