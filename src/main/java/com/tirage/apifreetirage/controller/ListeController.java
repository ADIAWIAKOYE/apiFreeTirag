package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.services.ListeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/readListe")
    public List<Liste> read(){

        return listeService.lire();
    }
}
