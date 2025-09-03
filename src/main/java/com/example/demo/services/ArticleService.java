package com.example.demo.services;

import com.example.demo.entities.Article;

import java.util.List;

public interface ArticleService {
    public Article generateAndSaveArticle(String seedText);
    public List<Article> getAllArticles();
}
