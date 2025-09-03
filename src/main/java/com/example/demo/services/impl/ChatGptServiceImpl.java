package com.example.demo.services.impl;

import com.example.demo.utils.ChatGptReq;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatGptServiceImpl {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${chatgpt.api.url}")
    private String apiUrl;

    @Value("${chatgpt.model}")
    private String model;

    @Value("${chatgpt.role}")
    private String role;

    @Value("${chatgpt.api.key}")
    private String apiKey;

    public String generateText(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String req = buildRequest(model, role, prompt );
        HttpEntity<String> entity = new HttpEntity<>(req, headers);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    public String buildRequest(String model, String role,  String prompt) {
        Map<String, String> messages = new HashMap<String, String>();
        String temp = prompt.substring(1, prompt.length()-1);
        List<Map<String, String>> messageList = new ArrayList<Map<String, String>>();
        messages.put("role", role);
        messages.put("content", temp);
        messageList.add(messages);

        ChatGptReq req = new ChatGptReq(model,messageList);
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(req);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
