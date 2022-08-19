package com.tirage.apifreetirage.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

}
