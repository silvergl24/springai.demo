package com.example.demo.services;

import com.example.demo.utils.ChatGptReq;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ChatGptService {
    public String generateText(String prompt);
    public ChatGptReq buildRequest(String model, String role, String prompt) throws JsonProcessingException;
}


