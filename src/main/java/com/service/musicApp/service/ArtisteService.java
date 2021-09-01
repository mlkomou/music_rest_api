package com.service.musicApp.service;

import com.service.musicApp.model.Artiste;
import com.service.musicApp.repository.ArtisteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ArtisteService {
    final UploadImageService uploadImageService;
    final ArtisteRepository artisteRepository;
    Map<String, Object> response = new HashMap<>();

    public ArtisteService(UploadImageService uploadImageService, ArtisteRepository artisteRepository) {
        this.uploadImageService = uploadImageService;
        this.artisteRepository = artisteRepository;
    }

    public ResponseEntity<Map<String, Object>> saveArtisite(Artiste artiste, MultipartFile photo) throws IOException {
      try {
          artiste.setPhoto(uploadImageService.uploadImage(photo));
          artiste.setDate_creation(new Date());
          artiste.setDate_modification(new Date());
          artiste.setSupprime(false);
          artisteRepository.save(artiste);
          response.put("code", 100);
          response.put("response", artiste);
          return new ResponseEntity<>(response, HttpStatus.OK);
      } catch (Exception e) {
          response.put("code", 200);
          response.put("response", "Erreur");
          return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    public ResponseEntity<Map<String, Object>> getArtiste() {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("code", 100);
            response.put("response", artisteRepository.findAll());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("code", 200);
            response.put("response", new ArrayList<>());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
