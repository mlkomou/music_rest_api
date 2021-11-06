package com.service.musicApp.service;

import com.service.musicApp.model.Categorie;
import com.service.musicApp.model.FormatSong;
import com.service.musicApp.model.Song;
import com.service.musicApp.model.Utilisateur;
import com.service.musicApp.repository.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SongService {

    final SongRepository songRepository;
    final UploadImageService uploadImageService;
    final UploadSongService uploadSongService;
    final
    Map<String, Object> response = new HashMap<>();

    public SongService(SongRepository songRepository, UploadImageService uploadImageService, UploadSongService uploadSongService) {
        this.songRepository = songRepository;
        this.uploadImageService = uploadImageService;
        this.uploadSongService = uploadSongService;
    }


    public ResponseEntity<Map<String, Object>> publishSong(
            Song song,
            MultipartFile photo,
            MultipartFile songFile) {

        try {
            song.setImg(uploadImageService.uploadImage(photo));
            song.setPath(uploadSongService.uploadSong(songFile));
            response.put("code", 100);
            response.put("response", song.getId());
            songRepository.save(song);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Song> getAllSongs() {
       return songRepository.getSongWithoutAlbum();
    }

    public ResponseEntity<Map<String, Object>> getSonOfAlbum(Long id) {
      try {
          List<Song> songs = songRepository.getAlbumSong(id);
          response.put("code", 100);
          response.put("response", songs);
          response.put("message", "Album affiché");
          return new ResponseEntity<>(response, HttpStatus.OK);
      } catch (Exception e) {
          response.put("code", 200);
          response.put("response", new ArrayList<>());
          response.put("message", "Album vide");
          return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
    public ResponseEntity<Map<String, Object>> getSonByCategorie(Long id) {
      try {
          List<Song> songs = songRepository.getSongByCategorieId(id);
          response.put("code", 100);
          response.put("response", songs);
          response.put("message", "Songs affichés");
          return new ResponseEntity<>(response, HttpStatus.OK);
      } catch (Exception e) {
          response.put("code", 200);
          response.put("response", new ArrayList<>());
          response.put("message", "Song vide");
          return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }


}
