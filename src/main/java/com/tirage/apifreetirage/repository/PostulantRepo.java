package com.tirage.apifreetirage.repository;

import com.tirage.apifreetirage.modele.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostulantRepo extends JpaRepository<Postulant, Long> {

    @Query(value = "select idpostulant from postulant where idlist_id_liste = :idliste", nativeQuery = true)
    public List<Object[]> FINDIDPOSTLIST(@Param("idliste") Long idliste);

}
