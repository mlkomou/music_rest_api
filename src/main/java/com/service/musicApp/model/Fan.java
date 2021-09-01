package com.service.musicApp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Fan")
@Access(AccessType.FIELD)
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
//        scope=Fan.class, resolver = DedupingObjectIdResolver.class, property="fan"
//)
public class Fan extends IdClasse {
    @Column(name = "nom")
    private String nom;

    @Column(name = "photo")
    private String photo;

    @OneToOne(mappedBy = "fan")
    private Utilisateur utilisateur;

    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinTable(name = "abonnement",
            joinColumns = {@JoinColumn(name = "fan")},
            inverseJoinColumns = {@JoinColumn(name = "artiste")})
    private List<Artiste> artistes;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinTable(
//            name = "abonnement",
//            joinColumns = @JoinColumn(name = "fan"),
//            inverseJoinColumns = @JoinColumn(name = "artiste"))
//    List<Artiste> artistes;

    public Fan() {

    }


    public void setPhoto(String photo) {
        this.photo = photo;
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

    public List<Artiste> getArtistes() {
        return artistes;
    }

    public void setArtistes(List<Artiste> artistes) {
        this.artistes = artistes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Fan{" +
                "nom='" + nom + '\'' +
                ", photo='" + photo + '\'' +
                ", utilisateur=" + utilisateur +
                ", artistes=" + artistes +
                '}';
    }
}
