package com.example.swd.service.recommendation;

import java.util.Map;

import com.example.swd.data.entity.User;
public interface RecommendationService {
    public Map<String, String> generateRecommendations(User user);
}
