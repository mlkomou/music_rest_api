package com.service.musicApp.repository;

import com.service.musicApp.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    @Query("select s from Song s where s.album IS NULL")
    List<Song> getSongWithoutAlbum();

    @Query("select s from Song s where s.album.id = ?1")
    List<Song> getAlbumSong(Long id);

    @Query("select s from Song s where s.categorie.id = ?1")
    List<Song> getSongByCategorieId(Long id);
}
