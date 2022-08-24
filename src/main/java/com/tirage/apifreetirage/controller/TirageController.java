package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.modele.PostulantTrie;
import com.tirage.apifreetirage.modele.Tirage;
import com.tirage.apifreetirage.services.ListeService;
import com.tirage.apifreetirage.services.PostulantService;
import com.tirage.apifreetirage.services.PostulantTrieService;
import com.tirage.apifreetirage.services.TirageService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tirage")
@AllArgsConstructor
public class TirageController {

    @Autowired
    /*
        definition des services: tirage, liste, postulant,

     */
    private final TirageService tirageService;
    private final ListeService listeService;
    private final PostulantService postulantService;
    private  final PostulantTrieService postulantTrieService;

    @PostMapping("/createTirage/{libelle_liste}/{nbre}")
    public List<PostulantTrie> create(@RequestBody Tirage tirage, @PathVariable String libelle_liste, @PathVariable Long nbre){

        if (tirageService.trouverTirageParLibelle(tirage.getLibellet()) == null){//verifie si le tirage existe déjà

            //recuperation de la liste demandée par user
            Liste liste = listeService.trouverListeParLibelle(libelle_liste);

            long idliste = liste.getId_liste();//identifiant de la liste entrée par l'user

            //retourne tous les postulants d'une liste donnée
            List<Postulant> postuL = postulantService.TrouveridPostList(idliste);

            //on crée le tirage et recuperer le tirage crée dans l'objet de type tirage ttt
            Tirage ttt = tirageService.creer(tirage, liste);

            List<Postulant> lp = tirageService.trie(postuL, nbre);//recuperation des postulant trié dans lp

            //recuperation de l'id du tirage
            long idTirage = ttt.getId();

            //dans for dessous on parcours et enregistre la liste trié dans la table postulant trié
            for (Postulant p : lp){//parcours de la liste postulants trié

                //enregistrement de la liste triée
                postulantTrieService.creer(p.getIdpostulant(), p.getNom_postulant(), p.getPrenom_postulant(),p.getNumero_postulant(),p.getEmail(),idTirage);
            }

            //retourne les postulant triés
            return postulantTrieService.trouverPostulantTrieParIdtirage(idTirage);
        }else{
            return null;
        }

    }

    @GetMapping("/readTirage")
    public List<Tirage> read(){

        return tirageService.lire();
    }
}
