package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Postulant;

import java.util.List;

public interface PostulantService {

 List<Postulant> enregistrer(List<Postulant> listPost);

 List<Postulant> TrouveridPostList(long idListe);
}
