package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.PostulantTrie;
import com.tirage.apifreetirage.modele.Tirage;
import com.tirage.apifreetirage.repository.PostulantTrieRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class postulantTrieServiceImpl implements PostulantTrieService {

    @Autowired
    private  final PostulantTrieRepo postulantTrieRepo;

    @Override
    public int creer(long idpostulant, String nom_postulant, String prenom_postulant, long numero_postulant, String email, long idtirage_id) {

        /*for(int i = 0; i< postT.size(); i++)
        {
            postulantTrieRepo.save(postT.get(i));
        }*/
        //appelle
        return postulantTrieRepo.INSERTPOSTTIRE(idpostulant, nom_postulant, prenom_postulant, numero_postulant, email, idtirage_id);
    }

}
