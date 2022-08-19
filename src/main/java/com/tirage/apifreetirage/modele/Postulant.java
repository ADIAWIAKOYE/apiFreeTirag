package com.tirage.apifreetirage.modele;

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
    private String numero_postulant;
    //@Email(message = "Wrong e-mail")
    private String email_postulant;

    @ManyToOne
    @JoinColumn(name = "idlist_id_liste")
    private Liste idlist;
}
