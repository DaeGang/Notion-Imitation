package com.daegang.notion.article.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Article {

    private String id;
    private String title;
    private String content;
    private String parentId;

    private List<Article> children;
    private List<Article> parents;

    @Builder
    private Article(String id, String title, String content, String parentId, List<Article> children, List<Article> parents) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.parentId = parentId;
        this.children = children;
        this.parents = parents;
    }

    public boolean hasParent() {
        return !this.parentId.isBlank() && !this.parentId.equals("null");
    }

    public void addChildren(List<Article> children) {
        if(this.children == null) {
            this.children = new ArrayList<>();
        }

        this.children.addAll(children);
    }

    public void addParents(List<Article> parents) {
        if(this.parents == null) {
            this.parents = new ArrayList<>();
        }

        this.parents.addAll(parents);
    }
}
