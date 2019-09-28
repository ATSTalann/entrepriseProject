package com.viptic.entrepriseApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tache {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nom;
    @Column
    private Date dateDeb;
    @Column
    private Date dateFin;

    @ManyToOne
    @JoinColumn

    private Employer employer;

    @ManyToOne
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore

    private Projet projets;

    public Tache() {
    }

    public Tache(String nom, Date dateDeb, Date dateFin, Employer employer, Projet projets) {
        this.nom = nom;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.employer = employer;
        this.projets = projets;
    }

    public Projet getProjets() {
        return projets;
    }

    public void setProjets(Projet projets) {
        this.projets = projets;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
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
}
