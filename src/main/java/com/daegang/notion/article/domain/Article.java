package com.daegang.notion.article.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Article {

    private String id;
    private String title;
    private String content;
    private String parentId;

    private List<Article> subPages;
    private List<String> breadCrumbs;

    @Builder
    private Article(String id, String title, String content, String parentId, List<Article> subPages, List<String> breadCrumbs) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.parentId = parentId;
        this.subPages = subPages;
        this.breadCrumbs = breadCrumbs;
    }

    public boolean hasParent() {
        return !this.parentId.isBlank() && !this.parentId.equals("null");
    }

    public void addSubPages(List<Article> subPages) {
        if(this.subPages == null) {
            this.subPages = new ArrayList<>();
        }

        this.subPages.addAll(subPages);
    }

    public void addBreadCrumbs(List<String> breadCrumbs) {
        if(this.breadCrumbs == null) {
            this.breadCrumbs = new ArrayList<>();
        }

        this.breadCrumbs.addAll(breadCrumbs);
    }
}
