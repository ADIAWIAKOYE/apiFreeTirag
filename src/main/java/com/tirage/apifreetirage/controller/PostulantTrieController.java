package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.PostulantTrie;
import com.tirage.apifreetirage.repository.PostulantTrieRepo;
import com.tirage.apifreetirage.services.PostulantTrieService;
import com.tirage.apifreetirage.services.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/PostulantTrie")
@AllArgsConstructor
public class  PostulantTrieController {

    @Autowired
    private final PostulantTrieService postulantTrieService;//definition du service des postulant triés
    private final TirageService tirageService;

    private final PostulantTrieRepo postulantTrieRepo;

    //methode permettant de créer un postulant trié dans la table postulant trié
    public int create(long idpostulant, String nom_postulant, String prenom_postulant, long numero_postulant, String email, long idtirage_id){

        return postulantTrieService.creer(idpostulant, nom_postulant, prenom_postulant,numero_postulant, email,idtirage_id);
    }

    @GetMapping("/readPostlantTrie")
    public List<PostulantTrie> read(){

        return postulantTrieService.lire();
    }

    @GetMapping("/recupererPostulant/{libellet}")
    public List<PostulantTrie> recupererPostulantTire(@PathVariable String libellet){

        return postulantTrieService.trouverPostulantTrieParIdtirage(tirageService.trouverTirageParLibelle(libellet).getId());
    }

    @GetMapping("/recupererPostulantid/{id}")
    public List<PostulantTrie> recupererPostulantTireid(@PathVariable  Long id){

        return postulantTrieService.trouverPostulantTrieParIdtirage(id);
    }

}
