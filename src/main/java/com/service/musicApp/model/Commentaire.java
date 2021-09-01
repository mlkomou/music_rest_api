package com.service.musicApp.model;

import javax.persistence.*;

@Entity
@Table(name = "Commentaire")
@Access(AccessType.FIELD)
public class Commentaire extends IdClasse {
    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name="utilisateur", nullable=false)
    private Utilisateur utilisateur;

//    @ManyToOne
//    @JoinColumn(name="utilisateur")
//    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="song")
    private Song song;

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

//    public Utilisateur getUtilisateur() {
//        return utilisateur;
//    }
//
//    public void setUtilisateur(Utilisateur utilisateur) {
//        this.utilisateur = utilisateur;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
