package com.viptic.entrepriseApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categorie {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private  String description;
    @Column
    private Float salaireBase;
    @Column
    private  Float prixHeure;

    @ManyToOne
    @JoinColumn

    private Employer employer;


    public Categorie() {
    }

    public Categorie(String description, Float salaireBase, Float prixHeure, Employer employer) {
        this.description = description;
        this.salaireBase = salaireBase;
        this.prixHeure = prixHeure;
        this.employer = employer;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(Float salaireBase) {
        this.salaireBase = salaireBase;
    }

    public Float getPrixHeure() {
        return prixHeure;
    }

    public void setPrixHeure(Float prixHeure) {
        this.prixHeure = prixHeure;
    }
}
