package com.tirage.apifreetirage.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="postulantTrie")
@Getter
@Setter
@NoArgsConstructor
public class PostulantTrie{
    private Long id;
}
