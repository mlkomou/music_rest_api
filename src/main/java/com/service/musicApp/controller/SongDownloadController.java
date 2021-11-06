package com.service.musicApp.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class SongDownloadController {
    @ResponseBody
    @GetMapping("/song/download/{path}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("path") String song) {
        if(!song.equals("") || song != null) {
            try {
//				Path fileName = Paths.get("/var/silicon/fichiers/", song);
                Path fileName = Paths.get("C:\\music/songs/", song);
                byte[] buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("image/png"))
                        .body(byteArrayResource);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
