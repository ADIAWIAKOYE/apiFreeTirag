package com.tirage.apifreetirage.repository;

import com.tirage.apifreetirage.modele.Liste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface ListeRepo extends JpaRepository<Liste, Long> {
}
