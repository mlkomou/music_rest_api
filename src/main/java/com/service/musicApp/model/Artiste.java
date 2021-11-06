package com.service.musicApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Artiste")
@Access(AccessType.FIELD)
//@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class)

public class Artiste extends IdClasse {
    @Column(name = "nom")
    private String nom;

    @Column(name = "biographie", length = 500)
    private String biographie;

    @Column(name = "photo")
    private String photo;

//    @ManyToMany(mappedBy = "artistes", fetch = FetchType.LAZY)
//    Set<Fan> fans = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.DETACH , mappedBy = "artistes")
    Set<Fan> fans = new HashSet<Fan>();

    @OneToOne(mappedBy = "artiste")
    private Utilisateur utilisateur;

    public Set<Fan> getFans() {
        return fans;
    }

    public void setFans(Set<Fan> fans) {
        this.fans = fans;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }
}
