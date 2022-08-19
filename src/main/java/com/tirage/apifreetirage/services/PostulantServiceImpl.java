package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Postulant;
import com.tirage.apifreetirage.repository.PostulantRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class PostulantServiceImpl implements PostulantService{

    public final PostulantRepo postulantRepo;

    @Override
    public Postulant creer(@RequestBody Postulant postulant) {

        return postulantRepo.save(postulant);
    }
}
