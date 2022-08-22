package com.tirage.apifreetirage.repository;

import com.tirage.apifreetirage.modele.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostulantRepo extends JpaRepository<Postulant, Long> {
    //selection de tous les  postulants sur la liste donnée par l'user
    @Query(value = "select * from postulant where idlist_id_liste = :idlist_id_liste", nativeQuery = true)
    public List<Postulant> FINDIDPOSTLIST(@Param("idlist_id_liste") Long idliste);

}
