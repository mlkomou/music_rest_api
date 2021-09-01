package com.service.musicApp.model;

import javax.persistence.*;

@Entity
@Table(name = "likes")
@Access(AccessType.FIELD)
public class Like extends IdClasse {
    @Column(name = "userId")
    int userId;

    @ManyToOne
    @JoinColumn(name="utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="song")
    private Song song;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
