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
    public int creer(List<Integer> postT) {

        for(int i = 0; i< postT.size(); i++)
        {
            postulantTrieRepo.INSERTPOSTTIRE(postT.get(i));
        }
        return 1;
    }

}
