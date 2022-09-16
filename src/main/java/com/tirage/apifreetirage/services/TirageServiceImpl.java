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

    //definition du repositroy du tirage
    public final TirageRepo tirageRepo;

    //methode permettant de faire le trie
    @Override
    public List<Postulant> trie(List<Postulant> listAtrier, Long nbre) {

        //création d'une variable random
        Random rand = new Random();

        //declaration de la liste qui contiendra les postulants selectionnés
        List<Postulant> list = new ArrayList<>();

        /*
        * cette boucle prend un nombre de 0 à taille-1(lindex) de la liste à trié en suite
        * on se sert de cette index pour recuperer la valeur correspondante dans la liste à trié après
        * on supprimme cette valeur dans la liste à trié pour ne pas encore tombé dessus et en fin
        * on retourne la liste trié après la boucle
        * */
        for (int i = 0; i< nbre; i++)
        {
            //cette variable va contenir les index choisi par random aleatoirement
            Integer index = rand.nextInt(listAtrier.size());

            //l'ajout de la valeur de l'index choisit aleatoirement
            list.add(listAtrier.get(index));
            //suppression de la valeur choisi dans la liste à trier
            listAtrier.remove(listAtrier.get(index));
        }

        //on retourne les postulant trié
        return list;
    }

    //redefinition de la methode permettant de creer un tirage, elle prend le tirage et la liste
    @Override
    public Tirage creer(@RequestBody Tirage tirage, Liste liste) {

        //ajout de l'id de la liste à au tirage
        tirage.setIdliste(liste);

        //ajout de la date actuelle au tirage
        tirage.setDate(new Date());

        //retourne le tirage crée
        return tirageRepo.save(tirage);
    }


    //redefinition de la methode permettant de trover un tirage par son libelle
    @Override
    public Tirage trouverTirageParLibelle(String libellet) {

        //retourne le tirage correspondant au libelle passé en parametre
        return tirageRepo.findByLibellet(libellet);
    }

    @Override
    public List<Tirage> lire() {

        return tirageRepo.findAll();
    }

}
