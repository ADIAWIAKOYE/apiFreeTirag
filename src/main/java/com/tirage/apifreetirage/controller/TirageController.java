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
    public String create(@RequestBody Tirage tirage, @PathVariable String libelle_liste, @PathVariable Long nbre){
        Liste liste = listeService.trouverListeParLibelle(libelle_liste);
        List<Postulant> postuL = postulantService.TrouveridPostList(liste.getId_liste());
/*
       for (Object p: postuL)
       {
           System.out.println(p);
       }
*/      //List<Object> pl = ;
        //postulantTrieService.creer(pl.)

        //postulantTrieService.creer(postuL);
       List<Postulant> lp = tirageService.creer(tirage, postuL, nbre);//recuperation des id des postulant trié
        long idTirage = tirageService.trouverTirageParLibelle(tirage.getLibellet()).getId();

        for (Postulant p : lp){
            postulantTrieService.creer(p.getIdpostulant(), p.getNom_postulant(), p.getPrenom_postulant(),p.getNumero_postulant(),p.getEmail(),idTirage);
        }

        return "succes";
    }
}
