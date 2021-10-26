package com.example.fogvalleybackend.model;

import java.util.List;

public class Transcript {
    private String title;
    private String character;
    private List<String> lines;

    public String getTitle() {
        return title;
    }

    public Transcript setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCharacter() {
        return character;
    }

    public Transcript setCharacter(String character) {
        this.character = character;
        return this;
    }

    public List<String> getLines() {
        return lines;
    }

    public Transcript setLines(List<String> lines) {
        this.lines = lines;
        return this;
    }
}
