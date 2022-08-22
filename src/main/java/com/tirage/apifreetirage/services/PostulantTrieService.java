package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.PostulantTrie;

import java.util.List;

public interface PostulantTrieService {

    //int  creer(List<PostulantTrie> lt);
    int  creer(long idpostulant, String nom_postulant, String prenom_postulant, long numero_postulant, String email, long idtirage_id);

    List<PostulantTrie> trouverPostulantTrieParIdtirage(long idtirageid);
}

