package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.repository.PostulantRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;


@Service
@AllArgsConstructor
public class PostulantServiceImpl implements PostulantService{

    private PostulantRepo repoPost;

    @Override
    public List<Postulant> enregistrer(List<Postulant> listPost) {
        return repoPost.saveAll(listPost);
    }

    @Override
    public List<Object[]> TrouveridPostList(Long idListe) {

        return repoPost.FINDIDPOSTLIST(idListe);
    }

}
