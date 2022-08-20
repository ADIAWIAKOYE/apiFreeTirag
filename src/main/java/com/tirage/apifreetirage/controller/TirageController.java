package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.modele.Tirage;
import com.tirage.apifreetirage.services.ListeService;
import com.tirage.apifreetirage.services.PostulantService;
import com.tirage.apifreetirage.services.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tirage/{libelle_liste}")
@AllArgsConstructor
public class TirageController {

    private final TirageService tirageService;
    private final ListeService listeService;
    private final PostulantService postulantService;
    @PostMapping("/createTirage")
    public Tirage create(@RequestBody Tirage tirage, String libelle){
        Liste liste = listeService.trouverListeParLibelle(libelle);
        System.out.println(postulantService.TrouveridPostList(liste.getId_liste()));

        return tirageService.creer(tirage);
    }
}
