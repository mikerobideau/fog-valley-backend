package com.example.fogvalleybackend;

import com.example.fogvalleybackend.model.SaveTranscriptRequest;
import com.example.fogvalleybackend.model.TranscriptRequest;
import com.example.fogvalleybackend.model.TranscriptResponse;
import com.example.fogvalleybackend.model.UserRequest;
import com.example.fogvalleybackend.model.entity.User;
import com.example.fogvalleybackend.service.SavedGameService;
import com.example.fogvalleybackend.service.TranscriptService;
import com.example.fogvalleybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
public class FogValley {

    @Autowired
    private TranscriptService transcriptService;

    @Autowired
    private UserService userService;

    @Autowired
    private SavedGameService savedGameService;

    public static void main(String[] args) {
        SpringApplication.run(FogValley.class, args);
    }

    @PostMapping("/transcripts")
    @CrossOrigin(origins = "http://127.0.0.1:3000")
    public @ResponseBody
    ResponseEntity<TranscriptResponse> findTranscripts(@RequestBody TranscriptRequest request) {
        return new ResponseEntity(transcriptService.findTranscripts(request.getKeyword(), request.getUserId()),
                new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/save/transcripts")
    @CrossOrigin(origins = "http://127.0.0.1:3000")
    public @ResponseBody
    ResponseEntity saveTranscripts(@RequestBody SaveTranscriptRequest request) {
        savedGameService.saveTranscripts(request.getPaths(), request.getUserId());
        return new ResponseEntity(null, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/user")
    @CrossOrigin(origins = "http://127.0.0.1:3000")
    public @ResponseBody
    ResponseEntity<Optional<User>> findUser(@RequestBody UserRequest request) {
        Optional<User> user = userService.findById(request.getId());
        if (user.isEmpty()) {
            return new ResponseEntity(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(user.get().setPassword(null), new HttpHeaders(), HttpStatus.OK);
        }
    }
}