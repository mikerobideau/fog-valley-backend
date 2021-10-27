package com.example.fogvalleybackend.model;

public class TranscriptRequest {
    private String keyword;
    private String userId;

    public TranscriptRequest() {}

    public String getKeyword() {
        return keyword;
    }

    public TranscriptRequest setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public TranscriptRequest setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
