package com.tirage.apifreetirage.repository;

import com.tirage.apifreetirage.modele.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TirageRepo extends JpaRepository<Tirage, Long> {

}
