package com.example.fogvalleybackend.model;

import java.util.List;

public class SaveTranscriptRequest {
    private List<String> paths;
    private String userId;

    public SaveTranscriptRequest() {}

    public List<String> getPaths() {
        return paths;
    }

    public SaveTranscriptRequest setPaths(List<String> paths) {
        this.paths = paths;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public SaveTranscriptRequest setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
