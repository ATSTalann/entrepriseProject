package com.viptic.entrepriseApp.message.request;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
 
public class SignUpForm {
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
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
  
 
   
 
    public String getUsername() {
        return username;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setUsername(String username) {
        this.username = username;
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
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}