package com.service.musicApp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "favorie")
@Access(AccessType.FIELD)
public class Favorie extends IdClasse {
    @ManyToMany(mappedBy = "favoriesSongs")
    Set<Song> songs;

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
