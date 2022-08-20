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

    private final ListeService listeService;

    @PostMapping("/createListe")
    public Liste create(@RequestBody Liste liste){

        return listeService.creer(liste);
    }
}
