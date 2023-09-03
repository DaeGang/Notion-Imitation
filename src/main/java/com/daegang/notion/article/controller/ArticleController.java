package com.daegang.notion.article.controller;

import com.daegang.notion.article.domain.Article;
import com.daegang.notion.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/api/articles/{id}")
    public Article getById(@PathVariable String id) {
        return articleService.getById(id);
    }
}
