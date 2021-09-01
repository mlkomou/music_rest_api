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
public class ImageDownloadController {

	@ResponseBody
	@GetMapping("/image/download/{photo}")
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo) {
		if(!photo.equals("") || photo != null) {
			try {
//				Path fileName = Paths.get("/var/silicon/fichiers/", photo);
				Path fileName = Paths.get("C:\\music/images", photo);
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
