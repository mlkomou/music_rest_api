package com.service.musicApp.model;

import javax.persistence.*;

@Entity
@Table(name = "Detail")
@Access(AccessType.FIELD)
public class Detail extends IdClasse {

    @Column(name = "nbTelechargement")
    private int nbTelechargement;

    @Column(name = "nbEcoute")
    private int nbEcoute;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "song", referencedColumnName = "id")
    private Song song;

    public int getNbTelechargement() {
        return nbTelechargement;
    }

    public void setNbTelechargement(int nbTelechargement) {
        this.nbTelechargement = nbTelechargement;
    }

    public int getNbEcoute() {
        return nbEcoute;
    }

    public void setNbEcoute(int nbEcoute) {
        this.nbEcoute = nbEcoute;
    }
}
