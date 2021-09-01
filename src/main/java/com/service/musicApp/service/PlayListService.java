package com.service.musicApp.service;

import com.service.musicApp.model.PlayList;
import com.service.musicApp.repository.PlayListRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PlayListService {
    final PlayListRepository playListRepository;
    Map<String, Object> response = new HashMap<>();

    public PlayListService(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }

    public ResponseEntity<Map<String, Object>> savePlayList(PlayList playList) {
      try {
          playListRepository.save(playList);
          response.put("code", 100);
          response.put("response", playList.getId());
          response.put("message", "Enregistrement effectué");
          return new ResponseEntity<>(response, HttpStatus.OK);
      } catch (Exception e) {
          response.put("code", 200);
          response.put("response", new Object());
          response.put("message", "Enregistrement échoué");
          return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
}
