package com.service.musicApp.model;

import org.springframework.web.multipart.MultipartFile;


public class AlbumWithSong {
    MultipartFile imgAlbum;
    Album album;
    Song[] songs;
    MultipartFile[] songFiles;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public MultipartFile getImgAlbum() {
        return imgAlbum;
    }

    public void setImgAlbum(MultipartFile imgAlbum) {
        this.imgAlbum = imgAlbum;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public MultipartFile[] getSongFiles() {
        return songFiles;
    }

    public void setSongFiles(MultipartFile[] songFiles) {
        this.songFiles = songFiles;
    }
}


