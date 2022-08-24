package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.PostulantTrie;

import java.util.List;

public interface PostulantTrieService {

    //methode permettant de créer les postulant trié
    int  creer(long idpostulant, String nom_postulant, String prenom_postulant, long numero_postulant, String email, long idtirage_id);

    //methode permettant de retourner les postulant d'untirage donnée
    List<PostulantTrie> trouverPostulantTrieParIdtirage(long idtirageid);

    List<PostulantTrie> lire();
}

