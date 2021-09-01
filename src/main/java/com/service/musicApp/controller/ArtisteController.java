package com.service.musicApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.musicApp.model.Artiste;
import com.service.musicApp.service.ArtisteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ArtisteController {
    final ArtisteService artisteService;

    public ArtisteController(ArtisteService artisteService) {
        this.artisteService = artisteService;
    }

    @PostMapping("/artistes/create")
    public ResponseEntity<Map<String, Object>> saveArtiste(@RequestParam("artiste") String artisteString,
                                                           @RequestParam("photo")MultipartFile photo) throws IOException {
        
        Artiste artiste = new ObjectMapper().readValue(artisteString, Artiste.class);
       return artisteService.saveArtisite(artiste, photo);
    }

    @GetMapping("/artistes/liste")
    public ResponseEntity<Map<String, Object>> getAllArtiste() {
        return artisteService.getArtiste();
    }
}
