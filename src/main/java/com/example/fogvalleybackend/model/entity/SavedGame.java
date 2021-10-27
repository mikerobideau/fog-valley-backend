package com.example.fogvalleybackend.model.entity;
import com.example.fogvalleybackend.converter.UnlockedTranscriptsConverter;
import com.example.fogvalleybackend.model.UnlockedTranscripts;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Lob;


@Entity
@Table(name = "SAVED_GAME")
public class SavedGame {
    @Id
    private String userId;

    @Convert(converter = UnlockedTranscriptsConverter.class)
    @Lob
    private UnlockedTranscripts unlockedTranscripts;

    public SavedGame() {

    }

    public String getUserId() {
        return userId;
    }

    public SavedGame setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public UnlockedTranscripts getUnlockedTranscripts() {
        return unlockedTranscripts;
    }

    public SavedGame setUnlockedTranscripts(UnlockedTranscripts unlockedTranscripts) {
        this.unlockedTranscripts = unlockedTranscripts;
        return this;
    }
}
