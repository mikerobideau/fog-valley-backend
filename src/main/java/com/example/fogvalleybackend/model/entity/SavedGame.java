package com.example.fogvalleybackend.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "SAVED_GAME")
public class SavedGame {
    @Id
    private String userId;

    @Lob
    private String unlockedTranscripts;

    public SavedGame() {

    }

    public String getUserId() {
        return userId;
    }

    public SavedGame setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUnlockedTranscripts() {
        return unlockedTranscripts;
    }

    public SavedGame setUnlockedTranscripts(String unlockedTranscripts) {
        this.unlockedTranscripts = unlockedTranscripts;
        return this;
    }
}
