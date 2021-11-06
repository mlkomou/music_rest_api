package com.service.musicApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "album")
@Access(AccessType.FIELD)
public class Album extends IdClasse {
    @Column(name = "artiste", nullable = false, length = 255)
    String artiste;

    @Column(name = "nom", nullable = false, length = 255)
    String nom;

    @Column(name = "visibilte")
    private boolean visibilte;

    @Column(name = "description")
    private String description;

    @Column(name = "img", nullable = false, length = 255)
    String img;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="utilisateur")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy="album")
    private Set<Song> songs;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isVisibilte() {
        return visibilte;
    }

    public void setVisibilte(boolean visibilte) {
        this.visibilte = visibilte;
    }

    public String isDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
