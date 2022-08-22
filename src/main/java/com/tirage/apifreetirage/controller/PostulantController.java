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
    final private PostulantService postulantservice;
    final private ListeService listeService;
    //final private Liste liste;
/*
    @Autowired
    private PostulantRepo postrepo;
*/
    @RequestMapping("/import/excel/{libelle}")
    @ResponseBody
    public String importFormExcel(@Param("file") MultipartFile file, Liste liste, String libelle) {
        //listeService.ajouterIdListe();
        PostulantExcelimport excelImporter = new PostulantExcelimport();
        List<Postulant> postulantList = excelImporter.excelImport(file);
        if(postulantList.size()==0){
            return "Fichier vide";
        }else{
            liste.setDate_liste(new Date());
            if(listeService.trouverListeParLibelle(liste.getLibelle()) == null){//verifie si la liste existe déjàç
                Liste l= listeService.creer(liste);
                for (Postulant p:postulantList){
                    p.setIdlist(l);
                }
                postulantservice.enregistrer(postulantList);
                return "liste importé avec succes";
           } else {
                return "Cette liste existe déjà";
            }


        }
    }
}