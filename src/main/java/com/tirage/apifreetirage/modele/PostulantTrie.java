package com.tirage.apifreetirage.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="postulantTrie")
@Getter
@Setter
@NoArgsConstructor
public class PostulantTrie{
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idtirage_id")
    private Tirage idtirage;
}
