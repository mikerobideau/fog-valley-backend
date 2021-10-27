package com.example.fogvalleybackend.service;

import com.example.fogvalleybackend.model.UnlockedTranscript;
import com.example.fogvalleybackend.model.UnlockedTranscripts;
import com.example.fogvalleybackend.model.entity.SavedGame;
import com.example.fogvalleybackend.repository.SavedGameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SavedGameService {

    @Autowired
    private SavedGameRepository savedGameRepository;

    public SavedGameService() {

    }

    public void saveTranscripts(List<String> paths, String userId) {
        SavedGame savedGame = savedGameRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException());
        var unlockedTranscripts = savedGame.getUnlockedTranscripts().getMap();
        paths.forEach(path ->
                unlockedTranscripts.put(path, new UnlockedTranscript().setIsNew(true)));
        savedGame.setUnlockedTranscripts(new UnlockedTranscripts().setMap(unlockedTranscripts));
        savedGameRepository.save(savedGame);
    }

    public UnlockedTranscripts getUnlockedTranscripts(String id) {
        ObjectMapper mapper = new ObjectMapper();
        SavedGame savedGame = savedGameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Unabled to find saved game"));
        return savedGame.getUnlockedTranscripts();
    }
}