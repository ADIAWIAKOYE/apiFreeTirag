package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.repository.PostulantRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class PostulantServiceImpl implements PostulantService{
    private PostulantRepo repoPost;

    @Override
    public List<Postulant> enregistrer(List<Postulant> listPost) {
        return repoPost.saveAll(listPost);
    }
}
