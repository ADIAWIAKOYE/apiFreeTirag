package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.PostulantTrie;
import com.tirage.apifreetirage.repository.PostulantTrieRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class postulantTrieServiceImpl implements PostulantTrieService {

    private  final PostulantTrieRepo postulantTrieRepo;

    @Override
    public int creer() {

        /*for(int i = 0; i< postT.size(); i++)
        {
            postulantTrieRepo.save(postT.get(i));
        }*/
       // postulantTrieRepo.INSERTPOSTTIRE(id, idTrie);
        return 1;
    }

}
