package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.modele.PostulantExcelimport;
import com.tirage.apifreetirage.services.ListeService;
import com.tirage.apifreetirage.services.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/postulant")
@AllArgsConstructor
public class PostulantController {
    //@Autowired
    /*
    * Definition des services postulant, service
    * */
    final private PostulantService postulantservice;
    final private ListeService listeService;

   //Le controlleur permettant d'importer un fichier et créer automatiquement une liste
    @RequestMapping("/import/excel/{libelle}")//il prend en parametre le libelle de la liste
    @ResponseBody

    /*
    * MultipartFile, classe java permettant d'importer un ou plusieurs fichiers
    * */
    public String importFormExcel(@Param("file") MultipartFile file, Liste liste, String libelle) {

        /*
        * Instaciation de la classe qui permet d'importer un fichier, lire son contenu et
        * le mettre dans une liste de type postulant
        * */
        PostulantExcelimport excelImporter = new PostulantExcelimport();

        //stockage de la liste des postulants retournée par la classe "PostulantExcelimport"  dans postulantList
        List<Postulant> postulantList = excelImporter.excelImport(file);

        if(postulantList.size()==0){//verifie si la liste est vide
            return "Fichier vide";

        }else{//si la liste n'est pas vide
            liste.setDate_liste(new Date());//on modifie la date de la liste en lui donnant la date actuelle

            if(listeService.trouverListeParLibelle(liste.getLibelle()) == null){//verifie si la liste existe déjà

                Liste l= listeService.creer(liste);//on crée la liste et garder cette liste dans l

               /*
               * Dans la boucle for suivant on parcours la liste des postulants en lui ajoutant l'id de la liste
               * sur la quelle le tie a été tiré
               * */
                for (Postulant p:postulantList){
                    p.setIdlist(l);//ajout de l'id de la liste à tous les  postulants(foreign key)
                }
                postulantservice.enregistrer(postulantList);//enregistrement de la liste des postulants importés dans la base
                return "liste importé avec succes";
           } else {
                return "Cette liste existe déjà";
            }


        }
    }

    @GetMapping("/readPostulant")
    public List<Postulant> read(){

        return postulantservice.lire();
    }
}