package com.example.fogvalleybackend.model;

import java.util.HashMap;

public class UnlockedTranscripts {
    private HashMap<String, UnlockedTranscript> map;

    public UnlockedTranscripts() {}

    public HashMap<String, UnlockedTranscript> getMap() {
        return map;
    }

    public UnlockedTranscripts setMap(HashMap<String, UnlockedTranscript> map) {
        this.map = map;
        return this;
    }
}
