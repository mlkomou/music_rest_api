package com.service.musicApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.musicApp.model.Album;
import com.service.musicApp.model.AlbumWithSong;
import com.service.musicApp.model.Song;
import com.service.musicApp.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AlbumController {
    final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping(value = "/albums/create")
    ResponseEntity<Map<String, Object>> saveAlbum(
            @RequestParam("imgAlbum") MultipartFile imgAlbum,
            @RequestParam("songFiles") MultipartFile[] songFiles,
            @RequestParam("albumString") String albumString,
            @RequestParam("songString") String songString) throws IOException {
        Album album = new ObjectMapper().readValue(albumString, Album.class);
        Song[] songs = new ObjectMapper().readValue(songString, Song[].class);
        AlbumWithSong albumWithSong = new AlbumWithSong();
        albumWithSong.setAlbum(album);
        albumWithSong.setImgAlbum(imgAlbum);
        albumWithSong.setSongFiles(songFiles);
        albumWithSong.setSongs(songs);
       return albumService.saveAlbum(albumWithSong);
    }

    @PostMapping("/test/upload")
    ResponseEntity<Map<String, Object>> testUpload(@RequestParam("imagebase64") String base64Image) {
        return albumService.testUploadBase64(base64Image);
    }
    @GetMapping(value = "/albums/liste")
    public ResponseEntity<Map<String, Object>> getAlbms() {
        return albumService.getAlbums();
    }
}
