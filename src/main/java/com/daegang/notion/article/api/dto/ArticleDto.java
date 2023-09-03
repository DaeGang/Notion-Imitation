package com.daegang.notion.article.api.dto;

import lombok.Builder;


// 예시
public record ArticleDto() {


    public record PageRequsetDto(
            String title,
            String content
    ){}
    @Builder
    public record PageResponseDto(
            boolean success
    ){}


}
