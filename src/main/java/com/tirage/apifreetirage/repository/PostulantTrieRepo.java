package com.tirage.apifreetirage.repository;

import com.tirage.apifreetirage.modele.PostulantTrie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PostulantTrieRepo extends JpaRepository<PostulantTrie, Long> {

    @Modifying
    @Transactional
    @Query(value = "insert into postulant_trie(id) values (:id);", nativeQuery = true)
    public int INSERTPOSTTIRE(@Param("id") int id);
}
