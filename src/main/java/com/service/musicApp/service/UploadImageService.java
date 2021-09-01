package com.service.musicApp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.Calendar;

@Service
public class UploadImageService {
    Path path = Paths.get("C:\\music/images");
    public String uploadImage(MultipartFile photo) throws IOException {

        Calendar cal = Calendar.getInstance();
        Long millisDate = cal.getTimeInMillis();
        InputStream inputStream = photo.getInputStream();
        Files.copy(inputStream, path.resolve(millisDate + photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("naaaaaaaame: " +  millisDate.toString() + photo.getOriginalFilename());
        return millisDate.toString() + photo.getOriginalFilename();
    }
}
