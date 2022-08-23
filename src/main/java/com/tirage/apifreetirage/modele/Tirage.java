package com.tirage.apifreetirage.modele;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

//voir la classe Liste pour les commentaire des annotations


@Entity
@Table(name = "tirage")
@Data
@NoArgsConstructor
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private Date date;

    private  String libellet;

    //relation entre la table tirage et la table liste
    @ManyToOne
    @JoinColumn(name = "idliste_id_liste")
    private Liste idliste;


}
