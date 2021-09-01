package com.service.musicApp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.ZoneOffset;

@Service
public class UploadSongService {
    Path path = Paths.get("C:\\music/songs/");
    public String uploadSong(MultipartFile song) throws IOException {
//        LocalDate localDate = LocalDate.now();
//        Long millisDate = localDate.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
        InputStream inputStream = song.getInputStream();
        Files.copy(inputStream, path.resolve(song.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        return song.getOriginalFilename();
    }
}
