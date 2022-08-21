package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.modele.Tirage;
import com.tirage.apifreetirage.services.ListeService;
import com.tirage.apifreetirage.services.PostulantService;
import com.tirage.apifreetirage.services.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tirage")
@AllArgsConstructor
public class TirageController {

    private final TirageService tirageService;
    private final ListeService listeService;
    private final PostulantService postulantService;

    @PostMapping("/createTirage/{libelle_liste}/{nbre}")
    public List<Integer> create(@RequestBody Tirage tirage, @PathVariable String libelle_liste, @PathVariable Long nbre){
        Liste liste = listeService.trouverListeParLibelle(libelle_liste);
        List<Object[]> postuL = postulantService.TrouveridPostList(liste.getId_liste());
/*
       for (Object p: postuL)
       {
           System.out.println(p);
       }
*/
        return tirageService.creer(tirage, postuL, nbre);
    }
}
