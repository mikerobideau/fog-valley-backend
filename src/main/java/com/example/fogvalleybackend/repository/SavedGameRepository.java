package com.example.fogvalleybackend.repository;

import com.example.fogvalleybackend.model.entity.SavedGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedGameRepository extends JpaRepository<SavedGame, String> {
}
