package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.Tirage;
import com.tirage.apifreetirage.services.PostulantService;
import com.tirage.apifreetirage.services.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Tirage")
@AllArgsConstructor
public class TirageController {

    private final TirageService tirageService;

    @PostMapping("/createTirage")
    public Tirage create(@RequestBody Tirage tirage){
        return tirageService.creer(tirage);
    }
}
