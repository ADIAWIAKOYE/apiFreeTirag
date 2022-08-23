package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.services.ListeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Liste")
@AllArgsConstructor
public class ListeController {
    //definition du service liste
    private final ListeService listeService;

    //methode permettant de créer une liste
    @PostMapping("/createListe")
    public Liste create(@RequestBody Liste liste){//prend une liste en format Json
        return listeService.creer(liste);//creation de la liste
    }
}
