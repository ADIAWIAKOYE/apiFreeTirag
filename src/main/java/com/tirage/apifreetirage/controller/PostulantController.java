package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.modele.PostulantExcelimport;
import com.tirage.apifreetirage.repository.PostulantRepo;
import com.tirage.apifreetirage.services.PostulantService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@RequestMapping("/postulant")
@AllArgsConstructor
public class PostulantController {
    @Autowired
    final private PostulantService postulantservice;
/*
    @Autowired
    private PostulantRepo postrepo;
*/
    @RequestMapping("/import/excel")
    @ResponseBody
    public String importFormExcel(@Param("file") MultipartFile file){
        PostulantExcelimport excelImporter = new PostulantExcelimport();
        List<Postulant> postulantList = excelImporter.excelImport(file);
        postulantservice.enregistrer(postulantList);

        return "import succsfully";
    }
}
