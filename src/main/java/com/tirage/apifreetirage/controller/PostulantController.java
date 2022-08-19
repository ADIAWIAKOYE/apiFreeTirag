package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.services.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Postulant")
@AllArgsConstructor
public class PostulantController {

    private final PostulantService postulantService;

    @PostMapping("/createPostulant")
    public Postulant create(@RequestBody Postulant postulant){

        return postulantService.creer(postulant);
    }
}
