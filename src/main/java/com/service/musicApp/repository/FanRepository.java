package com.service.musicApp.repository;

import com.service.musicApp.model.Fan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FanRepository extends JpaRepository<Fan, Long> {
//    @Query(value = "SELECT f FROM Fan f WHERE f.id = ?1")
//    Fan getByFanId(Long id);
}
