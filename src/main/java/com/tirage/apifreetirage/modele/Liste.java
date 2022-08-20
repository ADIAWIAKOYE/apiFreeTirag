package com.tirage.apifreetirage.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "liste")
@Getter
@Setter
@NoArgsConstructor


public class Liste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_liste;
    private String libelle;
    private Date date_liste;


}
