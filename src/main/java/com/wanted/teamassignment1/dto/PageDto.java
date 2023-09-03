package com.wanted.teamassignment1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class PageDto {
    Long pageId;
    String title;
    String content;
    Long parentPage;
}
