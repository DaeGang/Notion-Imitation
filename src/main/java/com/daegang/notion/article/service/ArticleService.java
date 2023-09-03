package com.daegang.notion.article.service;

import com.daegang.notion.article.domain.Article;
import com.daegang.notion.article.infra.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article getById(String id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        List<Article> children = articleRepository.findChildrenByParentId(article.getId());
        article.addChildren(children);

        if(!article.hasParent()) {
            return article;
        }

        List<Article> parents = articleRepository.findParentsByParentId(article.getParentId());
        article.addParents(parents);

        return article;
    }
}
