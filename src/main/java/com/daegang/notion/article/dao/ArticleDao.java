package com.daegang.notion.article.dao;

import java.util.List;

public interface ArticleDao {
    List<String> findBreadCrumbsByParentId(Long pageId);
}