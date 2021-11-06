package com.service.musicApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
@Access(AccessType.FIELD)
public class Utilisateur extends IdClasse {
    @Column(name = "telephone")
    String telephone;

    @Column(name = "mot_de_passe")
    String mot_de_passe;

    @OneToMany(mappedBy="utilisateur")
    private Set<Like> likes;

    @OneToMany(mappedBy="utilisateur")
    private Set<Album> albums;

    @OneToMany(mappedBy="utilisateur")
    private Set<PlayList> playLists;

    @ManyToMany
    @JoinTable(
            name = "song_bougth",
            joinColumns = @JoinColumn(name = "utilisateur"),
            inverseJoinColumns = @JoinColumn(name = "song"))
    Set<Song> boughtSongs;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artiste", referencedColumnName = "id", nullable = true)
    private Artiste artiste;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fan", referencedColumnName = "id", nullable = true)
    private Fan fan;

//
//    @OneToMany(mappedBy="utilisateur")
//    private Set<Commentaire> commentaires = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy="utilisateur")
    private Set<Commentaire> commentaires;

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(Set<PlayList> playLists) {
        this.playLists = playLists;
    }

    public Set<Song> getBoughtSongs() {
        return boughtSongs;
    }

    public void setBoughtSongs(Set<Song> boughtSongs) {
        this.boughtSongs = boughtSongs;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

//    public Set<Commentaire> getCommentaires() {
//        return commentaires;
//    }
//
//    public void setCommentaires(Set<Commentaire> commentaires) {
//        this.commentaires = commentaires;
//    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "telephone='" + telephone + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", date_creation=" + date_creation +
                ", date_modification=" + date_modification +
                ", supprime=" + supprime +
                '}';
    }
}
