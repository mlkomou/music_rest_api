package com.service.musicApp.repository;

import com.service.musicApp.model.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtisteRepository extends JpaRepository<Artiste, Long> {
}
