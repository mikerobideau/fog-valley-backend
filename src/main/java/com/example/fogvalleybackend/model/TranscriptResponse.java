package com.example.fogvalleybackend.model;

import java.util.List;

public class TranscriptResponse {
    private boolean hasNewTranscripts;
    private int totalTranscripts;
    private int totalUnlockedTranscripts;
    private int totalLockedTranscripts;
    private int totalNewTranscripts;
    private List<Transcript> newTranscripts;
    private List<Transcript> previousTranscripts;
    private List<Transcript> lockedTranscripts;

    public TranscriptResponse() {}

    public boolean isHasNewTranscripts() {
        return hasNewTranscripts;
    }

    public TranscriptResponse setHasNewTranscripts(boolean hasNewTranscripts) {
        this.hasNewTranscripts = hasNewTranscripts;
        return this;
    }

    public int getTotalTranscripts() {
        return totalTranscripts;
    }

    public TranscriptResponse setTotalTranscripts(int totalTranscripts) {
        this.totalTranscripts = totalTranscripts;
        return this;
    }

    public int getTotalUnlockedTranscripts() {
        return totalUnlockedTranscripts;
    }

    public TranscriptResponse setTotalUnlockedTranscripts(int totalUnlockedTranscripts) {
        this.totalUnlockedTranscripts = totalUnlockedTranscripts;
        return this;
    }

    public int getTotalLockedTranscripts() {
        return totalLockedTranscripts;
    }

    public TranscriptResponse setTotalLockedTranscripts(int totalLockedTranscripts) {
        this.totalLockedTranscripts = totalLockedTranscripts;
        return this;
    }

    public int getTotalNewTranscripts() {
        return totalNewTranscripts;
    }

    public TranscriptResponse setTotalNewTranscripts(int totalNewTranscripts) {
        this.totalNewTranscripts = totalNewTranscripts;
        return this;
    }

    public List<Transcript> getNewTranscripts() {
        return newTranscripts;
    }

    public TranscriptResponse setNewTranscripts(List<Transcript> newTranscripts) {
        this.newTranscripts = newTranscripts;
        return this;
    }

    public List<Transcript> getPreviousTranscripts() {
        return previousTranscripts;
    }

    public TranscriptResponse setPreviousTranscripts(List<Transcript> previousTranscripts) {
        this.previousTranscripts = previousTranscripts;
        return this;
    }

    public List<Transcript> getLockedTranscripts() {
        return lockedTranscripts;
    }

    public TranscriptResponse setLockedTranscripts(List<Transcript> lockedTranscripts) {
        this.lockedTranscripts = lockedTranscripts;
        return this;
    }
}
