package com.tirage.apifreetirage.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="postulantTrie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostulantTrie{
    @Id
    private long idpostulant;
    private String nompostulant;
    private String prenompostulant;
    private long numeropostulant;
    private String email;

    @ManyToOne
    @JoinColumn(name = "idtirageid")
    private Tirage idtirage;


}
