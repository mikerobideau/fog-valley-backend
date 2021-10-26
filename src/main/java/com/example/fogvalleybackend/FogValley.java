package com.example.fogvalleybackend;

import com.example.fogvalleybackend.model.BruteForceRequest;
import com.example.fogvalleybackend.model.Transcript;
import com.example.fogvalleybackend.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class FogValley {

    @Autowired
    private TranscriptService transcriptService;

    public static void main(String[] args) {
        SpringApplication.run(FogValley.class, args);
    }

    @PostMapping("/brute_force")
    @CrossOrigin(origins = "http://127.0.0.1:3000")
    public @ResponseBody
    ResponseEntity<List<Transcript>> brute_force(@RequestBody BruteForceRequest request) {
        return new ResponseEntity(transcriptService.bruteForce(request.getKeyword()), new HttpHeaders(), HttpStatus.OK);
    }
}