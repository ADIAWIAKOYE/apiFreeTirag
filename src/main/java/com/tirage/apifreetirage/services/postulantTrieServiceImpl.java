package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.PostulantTrie;
import com.tirage.apifreetirage.modele.Tirage;
import com.tirage.apifreetirage.repository.PostulantTrieRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class postulantTrieServiceImpl implements PostulantTrieService {

    //definition du repository des postulant triés
    @Autowired
    private  final PostulantTrieRepo postulantTrieRepo;

    //redefinition de la methode permettant de creer les postulant trié
    @Override
    public int creer(long idpostulant, String nom_postulant, String prenom_postulant, long numero_postulant, String email, long idtirage_id) {

        //creation des postulant trié
        return postulantTrieRepo.INSERTPOSTTIRE(idpostulant, nom_postulant, prenom_postulant, numero_postulant, email, idtirage_id);
    }

    //redefinition de la methode qui retourne les postulant trié d'un tirage
    @Override
    public List<PostulantTrie> trouverPostulantTrieParIdtirage(long idtirageid) {

        //retour des postulant trié
        return postulantTrieRepo.FINDALLPOSTULANTTRIEPARID(idtirageid);
    }

    @Override
    public List<PostulantTrie> trouverPostulantTireParTirage(Tirage tirage) {
        return postulantTrieRepo.findByIdtirage(tirage);
    }
    public List<PostulantTrie> lire() {

        return postulantTrieRepo.findAll();
    }

}
