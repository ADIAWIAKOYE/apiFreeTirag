package com.tirage.apifreetirage.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "postulant")
@Setter
@Getter
@NoArgsConstructor
public class Postulant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_postulant;
    private String nom_postulant;
    private String prenom_postulant;
    private long numero_postulant;
    //@Email(message = "Wrong e-mail")
    private String email_postulant;

    @ManyToOne
    @JoinColumn(name = "idlist_id_liste")
    private Liste idlist;

    public Postulant(String nom_postulant, String prenom_postulant, long numero_postulant, String email_postulant) {
        this.nom_postulant = nom_postulant;
        this.prenom_postulant = prenom_postulant;
        this.numero_postulant = numero_postulant;
        this.email_postulant = email_postulant;
    }
}
