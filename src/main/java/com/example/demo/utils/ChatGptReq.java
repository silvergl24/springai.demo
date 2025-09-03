package com.example.demo.utils;

import java.util.List;
import java.util.Map;

public record ChatGptReq(String model, List<Map<String, String>> messages) {
}
