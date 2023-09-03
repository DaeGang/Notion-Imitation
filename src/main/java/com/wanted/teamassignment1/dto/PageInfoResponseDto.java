package com.wanted.teamassignment1.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class PageInfoResponseDto extends PageDto {
    List<PageDto> subPages;
    List<String> breadCrumbs;
    public static PageInfoResponseDto of(PageDto pageDto, List<PageDto> subPages, List<String> breadCrumbs) {
        return PageInfoResponseDto.builder()
                .pageId(pageDto.getPageId())
                .title(pageDto.getTitle())
                .content(pageDto.getContent())
                .parentPage(pageDto.getParentPage())
                .subPages(subPages)
                .breadCrumbs(breadCrumbs)
                .build();
    }
}
