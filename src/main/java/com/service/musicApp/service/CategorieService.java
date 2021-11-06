package com.service.musicApp.service;

import com.service.musicApp.model.Categorie;
import com.service.musicApp.repository.CategorieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategorieService {
     CategorieRepository categorieRepository;
    Map<String, Object> response = new HashMap<>();

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }
   public ResponseEntity<Map<String, Object>> getCategories() {
       try {
           List<Categorie> categorieList = categorieRepository.findAll();
           response.put("code", 100);
           response.put("response", categorieList);
           return new ResponseEntity<>(response, HttpStatus.OK);
       } catch (Exception e) {
           response.put("code", 300);
           response.put("response", "Liste vide");
           return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
