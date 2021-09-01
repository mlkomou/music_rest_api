package com.service.musicApp.model;

import javax.persistence.*;

@Entity
@Table(name = "playlist")
@Access(AccessType.FIELD)
public class PlayList extends IdClasse {

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
}
