package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Postulant;

import java.util.List;

//service du postulant
public interface PostulantService {

 //methode permettant d'enregistrer un postulant
 List<Postulant> enregistrer(List<Postulant> listPost);

 //methode permettant de recuperer tous les postulant d'une liste donnée
 List<Postulant> TrouveridPostList(long idListe);
}
