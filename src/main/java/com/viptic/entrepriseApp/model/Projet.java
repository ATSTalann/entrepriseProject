package com.viptic.entrepriseApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Projet {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nom;
    @Column
    private Date dateDeb;
    @Column
    private Date dateFin;
    @Column
    private Date dateDebEstimer;
    @Column
    private Date dateFinEstimer;






    public Projet() {
    }

    public Projet(String nom, Date dateDeb, Date dateFin, Date dateDebEstimer, Date dateFinEstimer) {
        this.nom = nom;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.dateDebEstimer = dateDebEstimer;
        this.dateFinEstimer = dateFinEstimer;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateDebEstimer() {
        return dateDebEstimer;
    }

    public void setDateDebEstimer(Date dateDebEstimer) {
        this.dateDebEstimer = dateDebEstimer;
    }

    public Date getDateFinEstimer() {
        return dateFinEstimer;
    }

    public void setDateFinEstimer(Date dateFinEstimer) {
        this.dateFinEstimer = dateFinEstimer;
    }
}
