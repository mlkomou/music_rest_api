package com.service.musicApp.model;


public class FormatSong {
    String titre;

    String sous_titre;

    String img;

    String path;

    String artiste;

    private boolean visibilte;

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

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public boolean isVisibilte() {
        return visibilte;
    }

    public void setVisibilte(boolean visibilte) {
        this.visibilte = visibilte;
    }
}
