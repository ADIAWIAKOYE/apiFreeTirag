package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.repository.PostulantRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;


@Service
@AllArgsConstructor
public class PostulantServiceImpl implements PostulantService{

    //definition du repository du postulant
    private PostulantRepo repoPost;

    //redefinition de la methode d'enregistrement des postulant
    @Override
    public List<Postulant> enregistrer(List<Postulant> listPost) {

        //enregistrement de la liste des postulant avec saveAll
        return repoPost.saveAll(listPost);
    }

    //redefinition de la methode de recuperation des postulants par l'id de la liste
    @Override
    public List<Postulant> TrouveridPostList(long idListe) {

        return repoPost.FINDIDPOSTLIST(idListe);//retour des postulant de la liste demandé
    }

}
