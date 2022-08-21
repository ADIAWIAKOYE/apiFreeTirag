package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Tirage;

import java.util.List;

public interface TirageService {

    List<Integer> creer(Tirage tirage, List<Object[]> listAtrier,  Long nbre);
}
