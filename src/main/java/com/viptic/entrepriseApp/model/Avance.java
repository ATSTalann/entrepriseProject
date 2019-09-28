package com.viptic.entrepriseApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Avance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private Date dateDemande;
    @Column
    private  float montant;
    @Column
    private boolean decision;

    @ManyToOne
    @JoinColumn
    /*@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore*/
    private Employer employer;

    public Avance() {
    }


    public Avance(Date dateDemande, float montant, boolean decision, Employer employer) {
        this.dateDemande = dateDemande;
        this.montant = montant;
        this.decision = decision;
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

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public boolean isDecision() {
        return decision;
    }

    public void setDecision(boolean decision) {
        this.decision = decision;
    }
}
