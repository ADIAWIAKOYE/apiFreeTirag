package com.tirage.apifreetirage.modele;

import lombok.*;

import javax.persistence.*;

//voir la classe Liste pour les commentaire des annotations

@Entity
@Table(name = "postulant")
@Data
@NoArgsConstructor
public class Postulant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idpostulant;

    private String nom_postulant;

    private String prenom_postulant;

    private long numero_postulant;


    private String email;

    //relation de la table postulant et la table liste(les trois ligne ci-dessous
    @ManyToOne
    @JoinColumn(name = "idlist_id_liste")//le nom de cette clé étrangère dans la base
    private Liste idlist;//definition de la classe liste

    //constructeur avec argument
    public Postulant(String nom_postulant, String prenom_postulant, long numero_postulant, String email_postulant) {

        this.nom_postulant = nom_postulant;

        this.prenom_postulant = prenom_postulant;

        this.numero_postulant = numero_postulant;

        this.email = email_postulant;
    }
}
