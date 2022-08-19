package com.tirage.apifreetirage.repository;

import com.tirage.apifreetirage.modele.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulantRepo extends JpaRepository<Postulant, Long> {
}
