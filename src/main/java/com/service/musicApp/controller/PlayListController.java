package com.service.musicApp.controller;

import com.service.musicApp.model.PlayList;
import com.service.musicApp.service.PlayListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PlayListController {
    final PlayListService playListService;

    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    @PostMapping(value = "/playlists/create")
    ResponseEntity<Map<String, Object>> savePlayLists(@RequestBody PlayList playList) {
        return playListService.savePlayList(playList);
    }
}
