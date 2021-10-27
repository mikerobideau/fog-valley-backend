package com.example.fogvalleybackend.service;

import com.example.fogvalleybackend.model.Transcript;
import com.example.fogvalleybackend.model.TranscriptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.ArrayList;

import static java.util.stream.Collectors.toList;

@Service
public class TranscriptService {

    @Autowired
    SavedGameService savedGameService;

    private HashMap<String, List<String>> transcriptMap = new HashMap();

    public TranscriptService() {
        transcriptMap.put("secret", List.of("professor/abc", "allen/def"));
        transcriptMap.put("secret2", List.of("professor/a123", "allen/a456"));
    }

    public TranscriptResponse findTranscripts(String keyword, String userId) {
        var savedGameTranscripts = savedGameService.getUnlockedTranscripts(userId);
        var previousPaths = savedGameTranscripts.getMap().keySet();
        var previousTranscripts = getTranscriptsFromPaths(previousPaths.stream().collect(toList()));
        var newPaths = getNewPaths(keyword, previousPaths);
        var newTranscripts = getTranscriptsFromPaths(newPaths);
        var numTotalTranscripts = transcriptMap.values().stream().mapToInt(i -> i.size()).sum();
        var numLockedTranscripts = numTotalTranscripts - newTranscripts.size() - previousTranscripts.size();
        var lockedTranscripts = IntStream.range(0, numLockedTranscripts)
            .mapToObj(i -> new Transcript()
                .setTitle(UUID.randomUUID().toString())
                .setCharacter(UUID.randomUUID().toString())
                .setLines(List.of()))
            .collect(toList());

        return new TranscriptResponse()
                .setHasNewTranscripts(newTranscripts.size() > 0)
                .setTotalTranscripts(numTotalTranscripts)
                .setTotalLockedTranscripts(numLockedTranscripts)
                .setTotalUnlockedTranscripts(numTotalTranscripts - numLockedTranscripts)
                .setTotalNewTranscripts(newTranscripts.size())
                .setNewTranscripts(newTranscripts)
                .setPreviousTranscripts(previousTranscripts)
                .setLockedTranscripts(lockedTranscripts);
    }

    private List<String> getNewPaths(String keyword, Set<String> unlockedTitles) {
        var matches = transcriptMap.get(keyword);
        if (matches != null) {
            return transcriptMap.get(keyword)
                .stream()
                .filter(path -> !unlockedTitles.contains(path))
                .collect(toList());
        } else {
            return List.of();
        }
    }

    private List<Transcript> getTranscriptsFromPaths(List<String> paths) {
        return paths.stream()
            .map(path -> {
                var data = path.split("/");
                try {
                    return new Transcript()
                        .setCharacter(data[0])
                        .setTitle(data[1])
                        .setLines(getLines("transcripts/" + path + ".txt"));
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }).collect(toList());
    }

    private List<String> getLines(String filename) throws IOException {
        var inputStream = new ClassPathResource(filename).getInputStream();
        var reader = new BufferedReader(new InputStreamReader(inputStream));
        var lines = new ArrayList<String>();
        while (reader.ready()) {
            lines.add(reader.readLine());
        }
        return lines;
    }
}
