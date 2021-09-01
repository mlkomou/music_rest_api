package com.service.musicApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Categorie")
@Access(AccessType.FIELD)
public class Categorie extends IdClasse {
    @Column(name = "nom")
    private String nom;

    @Column(name = "color")
    private String color;


    @JsonIgnore
    @OneToMany(mappedBy="categorie")
    private Set<Song> songs;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
