package com.example.fogvalleybackend.converter;

import com.example.fogvalleybackend.model.UnlockedTranscript;
import com.example.fogvalleybackend.model.UnlockedTranscripts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.HashMap;

@Converter
public class UnlockedTranscriptsConverter implements AttributeConverter<UnlockedTranscripts, String> {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(UnlockedTranscripts data) {
        String value = "";
        try {
            value = mapper.writeValueAsString(data.getMap());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public UnlockedTranscripts convertToEntityAttribute(String data) {
        var mapValue = new HashMap<String, UnlockedTranscript>();
        try {
            mapValue = mapper.readValue(data, new TypeReference<HashMap<String, UnlockedTranscript>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new UnlockedTranscripts().setMap(mapValue);
    }

}