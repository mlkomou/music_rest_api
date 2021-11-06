package com.service.musicApp.service;

import com.service.musicApp.model.Album;
import com.service.musicApp.model.AlbumWithSong;
import com.service.musicApp.model.Song;
import com.service.musicApp.repository.AlbumRepository;
import com.service.musicApp.repository.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class AlbumService {
    final UploadImageService uploadImageService;
    final AlbumRepository albumRepository;
    final UploadSongService uploadSongService;
    final SongRepository songRepository;
    final SongService songService;
    Map<String, Object> response = new HashMap<>();

    public AlbumService(UploadImageService uploadImageService, AlbumRepository albumRepository, UploadSongService uploadSongService, SongRepository songRepository, SongService songService) {
        this.uploadImageService = uploadImageService;
        this.albumRepository = albumRepository;
        this.uploadSongService = uploadSongService;
        this.songRepository = songRepository;
        this.songService = songService;
    }



   public ResponseEntity<Map<String, Object>> saveAlbum(AlbumWithSong albumWithSong) throws IOException {
       try {
           MultipartFile[] songFiles = albumWithSong.getSongFiles();
           Song[] songs = albumWithSong.getSongs();
           Album album = albumWithSong.getAlbum();
           album.setImg(uploadImageService.uploadImage(albumWithSong.getImgAlbum()));
           albumRepository.save(album);

           for(MultipartFile songFile : songFiles) {
               System.out.println("song file loop");
              uploadSongService.uploadSong(songFile);
              System.out.println("upload song: " + songFile.getOriginalFilename());
           }

           for (Song songObject : songs) {
               System.out.println("song loop");

               songObject.setImg(uploadImageService.uploadImage(albumWithSong.getImgAlbum()));
               songObject.setAlbum(album);
               songObject.setArtiste(album.getArtiste());
               songObject.setDate_creation(new Date());
               songObject.setDate_modification(new Date());
               songRepository.save(songObject);
           }
           response.put("code", 100);
           response.put("response", album.getId());
           response.put("message", "Album anregistré avec succès.");
           return new ResponseEntity<>(response, HttpStatus.OK);

       } catch (Exception e) {
           response.put("code", 200);
           response.put("response", e.fillInStackTrace());
           response.put("message", "Erreur d'enregistrement de l'album");
           return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }


    //test upload base64 image
   public ResponseEntity<Map<String, Object>> testUploadBase64(String base64Image) {
        Calendar cal = Calendar.getInstance();
        Long millisDate = cal.getTimeInMillis();
        String  pathFile = "C:\\music/images/" + millisDate + "KOMOU" + "png";
        try {
            FileOutputStream imageOutFile = new FileOutputStream(pathFile);
            // Converting a Base64 String into Image byte array
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);
            response.put("code", 100);
            response.put("response", 1);
            response.put("message", "Album anregistré avec succès.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            response.put("code", 200);
            response.put("response", null);
            response.put("message", "Erreur d'enregistrement de l'album");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getAlbums() {
        try {
            Map<String, Object> response = new HashMap<>();
            List<Album> albums = albumRepository.findAll();
            response.put("code", 100);
            response.put("response", albums);
            response.put("message", "Liste affichée avec succès.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("code", 200);
            response.put("response", e.fillInStackTrace());
            response.put("message", "Erreur d'affichage de la liste");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
