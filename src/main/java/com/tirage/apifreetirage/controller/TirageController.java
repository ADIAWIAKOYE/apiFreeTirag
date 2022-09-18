package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.*;
import com.tirage.apifreetirage.repository.PostulantRepo;
import com.tirage.apifreetirage.repository.TirageRepo;
import com.tirage.apifreetirage.services.ListeService;
import com.tirage.apifreetirage.services.PostulantService;
import com.tirage.apifreetirage.services.PostulantTrieService;
import com.tirage.apifreetirage.services.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tirage")
@AllArgsConstructor
public class TirageController {

    @Autowired
    /*
        definition des services: tirage, liste, postulant,

     */
    private final TirageService tirageService;
    private final ListeService listeService;
    private final PostulantService postulantService;
    private  final PostulantTrieService postulantTrieService;

    private final TirageRepo tirageRepo;

    private final PostulantRepo postulantRepo;

    @PostMapping("/createTirage/{libelle_liste}")
    public Erreur create(@RequestBody Tirage tirage, @PathVariable String libelle_liste){

        Erreur erreur = new Erreur();

        if (tirageService.trouverTirageParLibelle(tirage.getLibellet()) == null){//verifie si le tirage existe déjà

            //recuperation de la liste demandée par user
            Liste liste = listeService.trouverListeParLibelle(libelle_liste);

            long idliste = liste.getId_liste();//identifiant de la liste entrée par l'user

            if (postulantRepo.FINDIDPOSTLIST(idliste).size() >= tirage.getNbre()){
                //retourne tous les postulants d'une liste donnée
                List<Postulant> postuL = postulantService.TrouveridPostList(idliste);

                listeService.mettreAjourListeNombreTirage(liste);

                //on crée le tirage et recuperer le tirage crée dans l'objet de type tirage ttt
                Tirage ttt = tirageService.creer(tirage, liste);

                List<Postulant> lp = tirageService.trie(postuL, tirage.getNbre());//recuperation des postulant trié dans lp

                //recuperation de l'id du tirage
                long idTirage = ttt.getId();

                //dans for dessous on parcours et enregistre la liste trié dans la table postulant trié

                for (Postulant p : lp){ //parcours de la liste postulants trié

                    //enregistrement de la liste triée
                    postulantTrieService.creer(p.getIdpostulant(), p.getNom_postulant(), p.getPrenom_postulant(),p.getNumero_postulant(),p.getEmail(),idTirage);
                }

                erreur.setContenuErreur("Tirage effectué avec succes");

                //retourne les postulant triés
                return erreur;
            }else {
                erreur.setContenuErreur("Veuillez choisir un nombre plus petit");
                return erreur;
            }
        }else{
            erreur.setContenuErreur("Ce tirage existe déjà");
            return  erreur;

        }

    }


    @GetMapping("/readTirage")
    public List<Tirage> read(){

        return tirageService.lire();
}
    @GetMapping("/recupererTirages")
    public List<Tirage> recupererTouslesTirages(){
        return tirageRepo.findAll();
    }

    @GetMapping("/nombretirages")
    public int nombreTirages(){
        return tirageRepo.findAll().size();
    }

    @GetMapping("recupererTirageParIdliste/{id_liste}")
    public List<Tirage> recupererTiragesparListe(@PathVariable long id_liste){
        return tirageRepo.FIND_TIRAGE_BY_LISTE_ID(id_liste);

    }

    @GetMapping("recupererTirageParId/{id}")
    public Tirage recupererTiragesparIdTirage(@PathVariable long id){
        return tirageRepo.findById(id).get();
    }


}
