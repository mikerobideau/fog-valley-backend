package com.example.fogvalleybackend.service;

import com.example.fogvalleybackend.model.Transcript;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class TranscriptService {
    private HashMap<String, List<String>> map = new HashMap();

    public TranscriptService() {
        map.put("secret", List.of("professor/abc", "allen/def"));
    }

    public List<Transcript> bruteForce(String keyword) {
        System.out.println("Brute forcing " + keyword);
        var matches = map.get(keyword);
        if (matches == null) {
            return List.of();
        }
        return matches.stream()
            .map(path -> {
                var data = path.split("/");
                try {
                    return new Transcript()
                        .setCharacter(data[0])
                        .setTitle(data[1])
                        .setLines(getLines("transcripts/" + path + ".txt"));
                } catch (IOException e) {
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
