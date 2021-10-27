package com.example.fogvalleybackend.model;

public class UnlockedTranscript {
    private boolean isNew;

    public UnlockedTranscript () {

    }

    public boolean getIsNew() {
        return isNew;
    }

    public UnlockedTranscript setIsNew(boolean isNew) {
        this.isNew = isNew;
        return this;
    }
}
