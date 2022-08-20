package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.repository.ListeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListeServiceImpl implements ListeService {


    private final ListeRepo listeRepo;

    @Override
    public Liste creer(Liste liste) {
        return listeRepo.save(liste);
    }

    @Override
    public Liste trouverListeParLibelle(String libelle) {
        return listeRepo.findByLibelle(libelle);
    }

    @Override
    public int ajouterIdListe(Long idList) {

        return listeRepo.INSERTIDLIST(idList);
    }


}
