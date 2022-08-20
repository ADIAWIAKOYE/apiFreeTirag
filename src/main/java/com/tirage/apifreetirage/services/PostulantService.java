package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Postulant;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostulantService {
 List<Postulant> enregistrer(List<Postulant> listPost);
}
