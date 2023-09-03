package com.daegang.notion.article.infra;

import com.daegang.notion.article.domain.Article;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ArticleEntity {

    private Long id;
    private String title;
    private String content;
    private Long parentId;

    @Builder
    private ArticleEntity(Long id, String title, String content, Long parentId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.parentId = parentId;
    }

    public Article toDomain() {
        return Article.builder()
                .id(String.valueOf(this.id))
                .title(this.title)
                .content(this.content)
                .parentId(String.valueOf(this.parentId))
                .build();
    }
}
