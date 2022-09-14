package com.tirage.apifreetirage.repository;

import com.tirage.apifreetirage.modele.Liste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface ListeRepo extends JpaRepository<Liste, Long> {

    Liste findByLibelle(String libelle);

    @Modifying
    @Transactional
    @Query(value = "insert into postulant(idlist_id_liste) values (:idlist_id_liste);", nativeQuery = true)
    public int INSERTIDLIST(@Param("idlist_id_liste") Long idlist_id_liste);

    @Query(value = "select * from liste where nbre_tirage != 0", nativeQuery = true)
    public List<Liste> FIND_ALL_LISTE_TIREE();
}
