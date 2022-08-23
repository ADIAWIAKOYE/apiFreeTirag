package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.repository.ListeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListeServiceImpl implements ListeService {

    //definition du repository liste
    private final ListeRepo listeRepo;

    //redefinition de la methode de creation de liste
    @Override
    public Liste creer(Liste liste) {

        return listeRepo.save(liste);//creation de la liste
    }


    //redefinition de la methode de recuperation de la liste par son libelle
    @Override
    public Liste trouverListeParLibelle(String libelle) {

        return listeRepo.findByLibelle(libelle);//recuperation de la liste par libelle
    }

    //methode non utilisé
    @Override
    public int ajouterIdListe(Long idList) {

        return listeRepo.INSERTIDLIST(idList);
    }


}
