package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.modele.Tirage;
import com.tirage.apifreetirage.repository.TirageRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class TirageServiceImpl implements TirageService{

    public final TirageRepo tirageRepo;



    @Override
    public List<Postulant> trie(List<Postulant> listAtrier, Long nbre) {

        //création d'une variable random
        Random rand = new Random();
        //declaration de la liste qui contiendra les postulants selectionnés
        List<Postulant> list = new ArrayList<>();
        for (int i = 0; i< nbre; i++)
        {
            //cette variable va contenir les index choisi par random aleatoirement
            Integer index = rand.nextInt(listAtrier.size());

            //l'ajout de la valeur de l'index choisit aleatoirement
            list.add(listAtrier.get(index));
            //suppression de la valeur choisi dans la liste à trier
            listAtrier.remove(listAtrier.get(index));
        }
        //

        return list;
    }

    @Override
    public Tirage creer(@RequestBody Tirage tirage, Liste liste) {
        tirage.setIdliste(liste);
        tirage.setDate(new Date());
        return tirageRepo.save(tirage);
    }

    @Override
    public Tirage trouverTirageParLibelle(String libellet) {
        return tirageRepo.findByLibellet(libellet);
    }

}
