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

            Tirage ttt = tirageService.creer(tirage, liste);
            List<Postulant> lp = tirageService.trie(postuL, nbre);//recuperation des postulant trié

            long idTirage = ttt.getId();
            for (Postulant p : lp){
                postulantTrieService.creer(p.getIdpostulant(), p.getNom_postulant(), p.getPrenom_postulant(),p.getNumero_postulant(),p.getEmail(),idTirage);
            }
            return postulantTrieService.trouverPostulantTrieParIdtirage(idTirage);
        }else{
            return null;
        }

    }
}
