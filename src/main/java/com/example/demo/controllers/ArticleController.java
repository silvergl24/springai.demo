package com.example.demo.controllers;

import com.example.demo.entities.Article;
import com.example.demo.services.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleService;

    @PostMapping(value ="/articles")
    public Article generateArticle(@RequestParam String seedText) {
        return articleService.generateAndSaveArticle(seedText);
    }

    @GetMapping("/articles")
        public List<Article> getAllArticles() {
            return articleService.getAllArticles();
        }
}
