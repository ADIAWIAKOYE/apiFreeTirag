package com.tirage.apifreetirage.modele;

import lombok.*;

import javax.persistence.*;

//voir la classe Liste pour les commentaire des annotations et les relation entre les tables


@Entity
@Table(name="postulantTrie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostulantTrie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idpostulant;

    private String nompostulant;

    private String prenompostulant;

    private long numeropostulant;

    private String email;

    //relation entre la table postulant trié et tirage
    @ManyToOne
    @JoinColumn(name = "idtirageid")
    private Tirage idtirage;


}
