package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.repository.ListeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListeServiceImpl implements ListeService {


    private final ListeRepo listeRepo;

    @Override
    public Liste creer(Liste liste) {
        return listeRepo.save(liste);
    }
}
