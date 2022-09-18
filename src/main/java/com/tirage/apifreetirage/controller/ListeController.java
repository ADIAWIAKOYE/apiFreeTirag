package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.modele.Tirage;
import com.tirage.apifreetirage.repository.ListeRepo;
import com.tirage.apifreetirage.repository.TirageRepo;
import com.tirage.apifreetirage.services.ListeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Liste")
@AllArgsConstructor
public class ListeController {
    //definition du service liste
    private final ListeService listeService;
    private final ListeRepo listeRepo;

    private final TirageRepo tirageRepo;

    //methode permettant de créer une liste
    @PostMapping("/createListe")
    public Liste create(@RequestBody Liste liste){//prend une liste en format Json

        return listeService.creer(liste);//creation de la liste
    }

    @GetMapping("/readListe")
    public List<Liste> read(){

        return listeService.lire();
    }

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

    @GetMapping("/listeDonnee/{idliste}")
    public Liste recupererListe(@PathVariable long idliste){

        return listeService.recupererListeParId(idliste);

    }

    //recupere une liste par id du tirage
    @GetMapping("/listeTirageDonnee/{idTirage}")
    public Object recupererListeParIdTirage(@PathVariable long idTirage){

        long idliste = tirageRepo.findById(idTirage).get().getIdliste().getId_liste();

        return idliste;

    }

}
