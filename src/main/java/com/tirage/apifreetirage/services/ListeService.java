package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.modele.Tirage;


public interface ListeService {

    //methode permettant de creer  une liste
    Liste creer(Liste liste);

    //methode permettant de recuperer une liste par son libelle
    Liste trouverListeParLibelle(String libelle);

    //methode non utilisé
    int ajouterIdListe(Long idList);

    Liste mettreAjourListeNombreTirage(Liste liste);


}
