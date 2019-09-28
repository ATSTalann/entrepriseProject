package com.viptic.entrepriseApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Absence {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int nbrHeure;
    @Column
    private int nbrJour;
    @Column
    @NotNull
    private Date dateAbs;

    @ManyToOne
    @JoinColumn

    private Employer employer;



    public Absence() {
    }

    public Absence(int nbrHeure, int nbrJour, Date dateAbs, Employer employer) {
        this.nbrHeure = nbrHeure;
        this.nbrJour = nbrJour;
        this.dateAbs = dateAbs;
        this.employer = employer;
    }


    public Date getDateAbs() {
        return dateAbs;
    }

    public void setDateAbs(Date dateAbs) {
        this.dateAbs = dateAbs;
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

    public int getNbrHeure() {
        return nbrHeure;
    }

    public void setNbrHeure(int nbrHeure) {
        this.nbrHeure = nbrHeure;
    }

    public int getNbrJour() {
        return nbrJour;
    }

    public void setNbrJour(int nbrJour) {
        this.nbrJour = nbrJour;
    }
}
