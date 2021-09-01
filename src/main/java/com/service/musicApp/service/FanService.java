package com.service.musicApp.service;

import com.service.musicApp.model.Artiste;
import com.service.musicApp.model.Fan;
import com.service.musicApp.repository.FanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FanService {
    final FanRepository fanRepository;
    final UploadImageService uploadImageService;

    public FanService(FanRepository fanRepository, UploadImageService uploadImageService) {
        this.fanRepository = fanRepository;
        this.uploadImageService = uploadImageService;
    }

    public ResponseEntity<Map<String, Object>> saveFan(Fan fan, MultipartFile photo) {
        Map<String, Object> response = new HashMap<>();
        try {

            fan.setPhoto(uploadImageService.uploadImage(photo));
            fanRepository.save(fan);
            response.put("code", 100);
            response.put("response", fan);
            response.put("message", "Votre inscription a été prise en charge");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("code", 200);
            response.put("response", "Erreur");
            response.put("message", "Votre inscription a échoué");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> abonnementArtiste(Fan fan) {
        Map<String, Object> response = new HashMap<>();
        Optional<Fan> fanToSave = fanRepository.findById(fan.getId());
        Fan fan1 = new Fan();
        System.out.println("fanid " + fan.getId());
//        System.out.println("Artistes " + fan.getArtistes().toString());
       try {
           if(fanToSave.isPresent()) {
//               fanToSave.get().setArtistes(fan.getArtistes());
               List<Artiste> artistes = fan.getArtistes();
               fan1.setArtistes(artistes);
               fan1.setUtilisateur(fanToSave.get().getUtilisateur());
               fan1.setNom(fan.getNom());
               fan1.setDate_creation(fan.getDate_creation());
               fan1.setDate_modification(fan.getDate_modification());
               fan1.setSupprime(fan.isSupprime());
               fan1.setId(fan.getId());
               response.put("code", 100);
               response.put("message", "Vous êtes abonnés à " +  " " + "Artiste(s)");
               response.put("response", fan1);
               fanRepository.save(fan1);
               return new ResponseEntity<>(response, HttpStatus.OK);
           }
           else {
               response.put("code", 200);
               response.put("response", "Erreur");
               response.put("message", "Votre abonnement aux artistes a échoué");
               return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
           }
       } catch (Exception e) {
           response.put("code", 200);
           response.put("response", e.fillInStackTrace());
           response.put("message", "Votre abonnement aux artistes a échoué");
           return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }
}
