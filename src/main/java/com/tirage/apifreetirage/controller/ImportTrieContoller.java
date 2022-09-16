package com.tirage.apifreetirage.controller;


import com.fasterxml.jackson.databind.json.JsonMapper;
import com.tirage.apifreetirage.modele.*;
import com.tirage.apifreetirage.services.ListeService;
import com.tirage.apifreetirage.services.PostulantService;
import com.tirage.apifreetirage.services.PostulantTrieService;
import com.tirage.apifreetirage.services.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/importTrie")
@AllArgsConstructor
public class ImportTrieContoller {

    final private PostulantService postulantservice;
    final private ListeService listeService;
    private final TirageService tirageService;
    private final PostulantService postulantService;
    private  final PostulantTrieService postulantTrieService;


    @PostMapping("/import/excel/{libelle}/{libelleT}/{nbre}")//il prend en parametre le libelle de la liste
    public String importFormExcelT(@Param("file") MultipartFile file, Liste liste, @PathVariable String libelle, @PathVariable("libelleT") String libelleT, @PathVariable("nbre") Long nbre) {
        System.out.println(nbre);
        System.out.println(libelleT);

        Tirage tirage=new Tirage();
        tirage.setLibellet(libelleT);
        tirage.setNbre(nbre);
        try {
            //tirage=new JsonMapper().readValue(tir,Tirage.class);
            //System.out.println(tirage.getLibellet());

            PostulantExcelimport excelImporter = new PostulantExcelimport();

            //stockage de la liste des postulants retournée par la classe "PostulantExcelimport"  dans postulantList
            List<Postulant> postulantListT = excelImporter.excelImport(file);

            if(postulantListT.size()==0){//verifie si la liste est vide
                return "Fichier vide";

            }else{//si la liste n'est pas vide
                liste.setDate_liste(new Date());//on modifie la date de la liste en lui donnant la date actuelle

                if(listeService.trouverListeParLibelle(liste.getLibelle()) == null){//verifie si la liste existe déjà

                    Liste l= listeService.creer(liste);//on crée la liste et garder cette liste dans l

                    /*
                     * Dans la boucle for suivant on parcours la liste des postulants en lui ajoutant l'id de la liste
                     * sur la quelle le tie a été tiré
                     * */
                    for (Postulant p:postulantListT){
                        p.setIdlist(l);//ajout de l'id de la liste à tous les  postulants(foreign key)
                    }
                    postulantservice.enregistrer(postulantListT);//enregistrement de la liste des postulants importés dans la base

                    //la partie tirage

                    if (tirageService.trouverTirageParLibelle(tirage.getLibellet()) == null) {//verifie si le tirage existe déjà

                        //recuperation de la liste demandée par user
                        //  Liste liste = listeService.trouverListeParLibelle(libelle_liste);

                        long idliste = liste.getId_liste();//identifiant de la liste entrée par l'user

                        //retourne tous les postulants d'une liste donnée
                        List<Postulant> postuL = postulantService.TrouveridPostList(idliste);

                        listeService.mettreAjourListeNombreTirage(liste);

                        //on crée le tirage et recuperer le tirage crée dans l'objet de type tirage ttt
                        Tirage ttt = tirageService.creer(tirage, liste);

                        List<Postulant> lp = tirageService.trie(postuL, tirage.getNbre());//recuperation des postulant trié dans lp

                        //recuperation de l'id du tirage
                        long idTirage = ttt.getId();

                        //dans for dessous on parcours et enregistre la liste trié dans la table postulant trié
                        for (Postulant p : lp) {//parcours de la liste postulants trié

                            //enregistrement de la liste triée
                            postulantTrieService.creer(p.getIdpostulant(), p.getNom_postulant(), p.getPrenom_postulant(), p.getNumero_postulant(), p.getEmail(), idTirage);
                        }

                        //retourne les postulant triés
                        return "Postulant trier avec succes";
                    }
                    return "liste importé avec succes";
                } else {
                    return "Cette liste existe déjà";
                }


            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

        /*
         * Instaciation de la classe qui permet d'importer un fichier, lire son contenu et
         * le mettre dans une liste de type postulant
         * */
    }
}
