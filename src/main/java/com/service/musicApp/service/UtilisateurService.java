package com.service.musicApp.service;

import com.service.musicApp.model.Utilisateur;
import com.service.musicApp.repository.UtilisateurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UtilisateurService {
    final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public ResponseEntity<Map<String, Object>> saveUtilisateur(Utilisateur utilisateur) {
        Map<String, Object> response = new HashMap<>();
        try {
            utilisateurRepository.save(utilisateur);
            response.put("code", 100);
            response.put("response", utilisateur.getId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("code", 200);
            response.put("response", "Erreur");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
