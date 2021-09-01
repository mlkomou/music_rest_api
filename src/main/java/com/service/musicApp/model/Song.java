package com.service.musicApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "song")
@Access(AccessType.FIELD)
public class Song extends IdClasse {
    @Column(name = "titre", length = 255, nullable = false)
    String titre;

    @Column(name = "sous_titre", length = 255, nullable = false)
    String sous_titre;

    @Column(name = "img", length = 255, nullable = false)
    String img;

    @Column(name = "path", length = 255, nullable = false)
    String path;

    @Column(name = "artiste", length = 255, nullable = false)
    String artiste;

    @Column(name = "visibilte")
    private boolean visibilte;

    @Column(name = "prix")
    private int prix;

    @ManyToOne
    @JoinColumn(name="utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="categorie")
    private Categorie categorie;

    @ManyToMany(mappedBy = "boughtSongs")
    Set<Utilisateur> bought;

    @OneToMany(mappedBy="song")
    private Set<Commentaire> commentaires;

    @JsonIgnore
    @OneToMany(mappedBy="song")
    private Set<PlayList> playLists;

    @OneToMany(mappedBy="song")
    private Set<Like> likes;

    @OneToOne(mappedBy = "song")
    private Detail detail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="album")
    private Album album;

    @ManyToMany
    @JoinTable(
            name = "song_favorie",
            joinColumns = @JoinColumn(name = "song"),
            inverseJoinColumns = @JoinColumn(name = "favorie"))
    Set<Favorie> favoriesSongs;

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Set<Favorie> getFavoriesSongs() {
        return favoriesSongs;
    }

    public void setFavoriesSongs(Set<Favorie> favoriesSongs) {
        this.favoriesSongs = favoriesSongs;
    }

    public boolean isVisibilte() {
        return visibilte;
    }

    public void setVisibilte(boolean visibilte) {
        this.visibilte = visibilte;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Set<Utilisateur> getBought() {
        return bought;
    }

    public void setBought(Set<Utilisateur> bought) {
        this.bought = bought;
    }

    public Set<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Set<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public Set<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(Set<PlayList> playLists) {
        this.playLists = playLists;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSous_titre() {
        return sous_titre;
    }

    public void setSous_titre(String sous_titre) {
        this.sous_titre = sous_titre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Song{" +
                "titre='" + titre + '\'' +
                ", sous_titre='" + sous_titre + '\'' +
                ", img='" + img + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
