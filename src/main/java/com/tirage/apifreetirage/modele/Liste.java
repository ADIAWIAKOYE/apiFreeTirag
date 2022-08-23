package com.tirage.apifreetirage.modele;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;


//transforme cette classe en table
@Entity

//definis le nom de la table
@Table(name = "liste")

//permet d'inclure les getter et setter et toString
@Data

//paramettre sans arguments
@NoArgsConstructor

public class Liste {

    @Id//permet de prendre id_liste comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id de la liste
    private long id_liste;

    private String libelle;

    private Date date_liste;


}
