package com.service.musicApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.musicApp.model.Song;
import com.service.musicApp.model.SongUser;
import com.service.musicApp.model.Utilisateur;
import com.service.musicApp.service.SongService;
import com.service.musicApp.service.UploadImageService;
import com.service.musicApp.service.UploadSongService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class SongController {
    Map<String, Object> response = new HashMap<>();
    final SongService songService;
    final UploadImageService uploadImageService;
    final UploadSongService uploadSongService;
    private static final Logger LOG  = LoggerFactory.logger(SongController.class);

    public SongController(SongService songService, UploadImageService uploadImageService, UploadSongService uploadSongService) {
        this.songService = songService;
        this.uploadImageService = uploadImageService;
        this.uploadSongService = uploadSongService;
    }

    @PostMapping(value = "/songs/create")
    public ResponseEntity<Map<String, Object>> publishSong(
            @RequestParam("song") String songString,
            @RequestParam("user") String userString,
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("songFile") MultipartFile songFile) throws JsonProcessingException {
            LOG.debug("avant json");

            Song song = new ObjectMapper().readValue(songString, Song.class);
            LOG.debug("song json");
            Utilisateur utilisateur = new ObjectMapper().readValue(userString, Utilisateur.class);
            System.out.println("User: " + utilisateur.getId());
            song.setUtilisateur(utilisateur);

//
            songService.publishSong(song, photo, songFile);
            response.put("code", 100);
            response.put("response", song.getId());
//            return ResponseEntity.ok(song);
        return new ResponseEntity<>(response, HttpStatus.OK);
        }

        @GetMapping(value = "/songs")
        public ResponseEntity<List<Song>> getAllSong() {
            return ResponseEntity.ok(songService.getAllSongs());
        }

        @GetMapping(value = "/songs/album/{id}")
        public ResponseEntity<Map<String, Object>> getSongByAlbum(@PathVariable("id") Long id) {
            return songService.getSonOfAlbum(id);
        }

        @GetMapping(value = "/songs/categorie/{id}")
        public ResponseEntity<Map<String, Object>> getSongByCategorie(@PathVariable("id") Long id) {
            return songService.getSonByCategorie(id);
        }
}
