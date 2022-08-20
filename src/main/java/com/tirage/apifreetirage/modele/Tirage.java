package com.tirage.apifreetirage.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tirage")
@Getter
@Setter
@NoArgsConstructor
public class Tirage {
    @Id
    private Long id;
    private Date date;

    private  String libelle;

    @ManyToOne
    @JoinColumn(name = "idliste_id_liste")
    private Liste idliste;


}
