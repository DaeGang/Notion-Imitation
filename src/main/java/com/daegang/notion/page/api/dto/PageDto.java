package com.daegang.notion.page.api.dto;

import lombok.Builder;


// 예시
public record PageDto() {


    public record PageRequsetDto(
            String title,
            String content
    ){}
    @Builder
    public record PageResponseDto(
            boolean success
    ){}


}
