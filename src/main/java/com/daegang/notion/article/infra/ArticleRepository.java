package com.daegang.notion.article.infra;

import com.daegang.notion.article.domain.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    Optional<Article> findById(String id);
    List<Article> findChildrenByParentId(String id);
    List<Article> findParentsByParentId(String id);
}
