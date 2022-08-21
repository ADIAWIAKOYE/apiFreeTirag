package com.tirage.apifreetirage.controller;

import com.tirage.apifreetirage.modele.PostulantTrie;
import com.tirage.apifreetirage.services.PostulantTrieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PostulantTrie")
@AllArgsConstructor
public class PostulantTrieController {

    @Autowired
    private final PostulantTrieService postulantTrieService;

    public int create(List<Integer> postT){

        return postulantTrieService.creer(postT);
    }

}
