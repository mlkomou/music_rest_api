package com.service.musicApp.controller;

import com.service.musicApp.service.CategorieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class CategorieController {
     CategorieService categorieService;
    Map<String, Object> response = new HashMap<>();

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping(value = "/categories")
    ResponseEntity<Map<String, Object>> getCategories() {
        return categorieService.getCategories();
    }
}
