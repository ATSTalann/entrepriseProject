package com.viptic.entrepriseApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Congé {
    @Id
    @GeneratedValue
    private int id ;
    @Column
    private Date dateDeb;
    @Column
    private Date dateFin;
    @Column
    private String raison;
    @Column
    private String etat;

    @ManyToOne
    @JoinColumn

    private Employer employer;



    public Congé() {
    }

    public Congé(Date dateDeb, Date dateFin, String raison, String etat, Employer employer) {
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.raison = raison;
        this.etat = etat;
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

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }
}
