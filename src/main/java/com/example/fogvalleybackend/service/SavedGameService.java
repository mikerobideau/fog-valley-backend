package com.example.fogvalleybackend.service;

import com.example.fogvalleybackend.model.UnlockedTranscript;
import com.example.fogvalleybackend.model.entity.SavedGame;
import com.example.fogvalleybackend.repository.SavedGameRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
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
        try {
            ObjectMapper mapper = new ObjectMapper();
            var unlockedTranscripts = mapper.readValue(savedGame.getUnlockedTranscripts(),
                    new TypeReference<HashMap<String, UnlockedTranscript>>() {});
            //TODO:  NEED TO ENCODE THIS JSON SO THERE ARE QUOTES AROUND KEYS
            paths.forEach(path ->
                    unlockedTranscripts.put("\"" + path + "\"", new UnlockedTranscript().setIsNew(true)));
            savedGame.setUnlockedTranscripts(unlockedTranscripts.toString());
            savedGameRepository.save(savedGame);
        } catch (JsonProcessingException e) {
           return;
        }

    }

    public HashMap<String, UnlockedTranscript> getUnlockedTranscripts(String id) {
        ObjectMapper mapper = new ObjectMapper();
        SavedGame savedGame = savedGameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Unabled to find saved game"));
        try {
            return mapper.readValue(savedGame.getUnlockedTranscripts(), new TypeReference<HashMap<String, UnlockedTranscript>>() {});
        } catch (JsonProcessingException e) {
            return new HashMap();
        }
    }
}