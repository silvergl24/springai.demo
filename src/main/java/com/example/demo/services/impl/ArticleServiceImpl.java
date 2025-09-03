package com.example.demo.services.impl;

import com.example.demo.entities.Article;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.services.ChatGptService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleServiceImpl {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ChatGptServiceImpl chatGptService;

    public Article generateAndSaveArticle(String seedText) {
        String generatedContent = chatGptService.generateText(seedText);
        String generatedTitle = "Generated Title: " + seedText.substring(0, Math.min(10, seedText.length())) + "...";
        Article article = new Article(generatedTitle, generatedContent);
        return articleRepository.save(article);
    }
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
