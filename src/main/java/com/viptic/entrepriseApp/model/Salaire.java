package com.viptic.entrepriseApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Salaire {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private Date dateDeb;
    @Column
    private Date dateFin;
    @Column
    private  float totalPrime;
    @Column
    private float totalRetenu;
    @Column
    private float salaireNet;

    @ManyToOne
    @JoinColumn
    private Employer employer;

    public Salaire() {
    }

    public Salaire(Date dateDeb, Date dateFin, float totalPrime, float totalRetenu, float salaireNet, Employer employer) {
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.totalPrime = totalPrime;
        this.totalRetenu = totalRetenu;
        this.salaireNet = salaireNet;
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

    public float getTotalPrime() {
        return totalPrime;
    }

    public void setTotalPrime(float totalPrime) {
        this.totalPrime = totalPrime;
    }

    public float getTotalRetenu() {
        return totalRetenu;
    }

    public void setTotalRetenu(float totalRetenu) {
        this.totalRetenu = totalRetenu;
    }

    public float getSalaireNet() {
        return salaireNet;
    }

    public void setSalaireNet(float salaireNet) {
        this.salaireNet = salaireNet;
    }
}
