package com.example.demo.repositories;

import com.example.demo.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>{
}
