package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.repository.ListeRepo;
import com.tirage.apifreetirage.services.ListeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Liste")
@AllArgsConstructor
public class ListeController {
    //definition du service liste
    private final ListeService listeService;
    private final ListeRepo listeRepo;

    //methode permettant de créer une liste
    @PostMapping("/createListe")
    public Liste create(@RequestBody Liste liste){//prend une liste en format Json
        return listeService.creer(liste);//creation de la liste
    }

<<<<<<< HEAD
    @GetMapping("/readListe")
    public List<Liste> read(){

        return listeService.lire();
    }
=======
    @GetMapping("/listes")
    public List<Liste> recupererListe(){
        return listeRepo.findAll();
    }

    @GetMapping("/listesTirees")
    public List<Liste> recupererToutesLesListes(){

        return listeService.recupererListeTirees();
    }

    @GetMapping("/listesNombreTirees")
    public int recupererNombreListes(){

        return listeService.recupererListeTirees().size();
    }

>>>>>>> main
}
