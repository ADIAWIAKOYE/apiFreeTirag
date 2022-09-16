package com.tirage.apifreetirage.repository;

import com.tirage.apifreetirage.modele.Liste;
import com.tirage.apifreetirage.modele.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TirageRepo extends JpaRepository<Tirage, Long> {
    Tirage findByLibellet(String libellet);

    @Query(value = "select * from tirage where idliste_id_liste = :idliste_id_liste", nativeQuery = true)
    public List<Tirage> FIND_TIRAGE_BY_LISTE_ID(@Param("idliste_id_liste") long idliste_id_liste);

    //requete permettant d'inser un tirage avec son id

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tirage(date, libellet, idliste_id_liste) VALUES(NOW(),?,?);",nativeQuery = true)
    public int INSERERTIRAGE(String libellet, long idliste_id_liste);


}
