package com.viptic.entrepriseApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Employer implements  Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    private long id;
   @Column
    private Date dateEmbauche;
    @Column
    private Date dateNais;
    @Column
    private String username;
    @Column
    private String prenom;
    @Column
    private String situationFamiliale;
    @Column
    private String adresse;
    @Column
    @Size(min = 8)
    @NotNull
    private String cin;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private  String photo;
 
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
      joinColumns = @JoinColumn(name = "user_id"), 
      inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



    public Employer() {
    }


   

    public Set<Role> getRoles() {
		return roles;
	}




	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}




	public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public Employer(String prenom,String nom, String email,String password) {
    	this.username = nom;
    	this.prenom = prenom;
    	this.email = email;
		this.password = password;
    }
           

    public Employer(long id, Date dateEmbauche, Date dateNais, String nom, String prenom, String situationFamiliale,
			String adresse, String cin, String email, String password, String photo, Set<Role> roles) {
		super();
		this.id = id;
		this.dateEmbauche = dateEmbauche;
		this.dateNais = dateNais;
		this.username = nom;
		this.prenom = prenom;
		this.situationFamiliale = situationFamiliale;
		this.adresse = adresse;
		this.cin = cin;
		this.email = email;
		this.password = password;
		this.photo = photo;
		this.roles = roles;
	}


	public Employer(Date dateEmbauche, Date dateNais, String username, String prenom, String situationFamiliale,
			String adresse, String cin, String email, String password, String photo) {
		
		this.dateEmbauche = dateEmbauche;
		this.dateNais = dateNais;
		this.username = username;
		this.prenom = prenom;
		this.situationFamiliale = situationFamiliale;
		this.adresse = adresse;
		this.cin = cin;
		this.email = email;
		this.password = password;
		this.photo = photo;
		
	}




	public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Date getDateNais() {
        return dateNais;
    }

    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

   

    


	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }






}
