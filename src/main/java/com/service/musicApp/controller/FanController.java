package com.service.musicApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.musicApp.model.Fan;
import com.service.musicApp.model.FanArtistes;
import com.service.musicApp.model.Utilisateur;
import com.service.musicApp.repository.FanRepository;
import com.service.musicApp.service.FanService;
import com.service.musicApp.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FanController {
    final FanService fanService;
    final UtilisateurService utilisateurService;
    final FanRepository fanRepository;

    public FanController(FanService fanService, UtilisateurService utilisateurService, FanRepository fanRepository) {
        this.fanService = fanService;
        this.utilisateurService = utilisateurService;
        this.fanRepository = fanRepository;
    }

    @PostMapping("/fans/create")
    public ResponseEntity<Map<String, Object>> saveFan(@RequestParam("fan") String fanString, MultipartFile photo) throws JsonProcessingException {
        Fan fan = new ObjectMapper().readValue(fanString, Fan.class);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur = fan.getUtilisateur();
        utilisateur.setFan(fan);
        fan.setUtilisateur(fan.getUtilisateur());
        utilisateurService.saveUtilisateur(utilisateur);
     return  fanService.saveFan(fan, photo);
}

//@GetMapping("/fans/all")
//public List<Fan> getAllFan() {
//        return fanService.getAllFan();
//}

@PutMapping("/fans/abonnement")
    public ResponseEntity<Map<String, Object>> abonnement(@RequestBody Fan fan) {
//        System.out.println(fanArtistes.toString());
//    Optional<Fan> fan = fanRepository.findById(fanArtistes.getFanId());
//    System.out.println("fan found: " + fan.get().getId());
//    System.out.println(fan.toString());
//        return "fan id= "+ fanArtistes.getFanId();
    return fanService.abonnementArtiste(fan);
    }

}
