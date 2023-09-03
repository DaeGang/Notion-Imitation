package com.wanted.teamassignment1.result;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultCode {

    PAGE_CREATE_SUCCESS("M004", "페이지를 성공적으로 등록하였습니다." ),
    PAGE_FIND_SUCCESS("M005", "입력한 postId의 페이지를 성공적으로 조회하였습니다."),
    ALL_PAGES_FIND_SUCCESS("M006", "페이지 목록을 성공적으로 조회하였습니다."),
    PAGE_MODIFY_SUCCESS("M007", "입력한 pageId의 페이지를 성공적으로 수정하였습니다."),

    POST_DELETE_SUCCESS("M008", "입력한 pageId의 페이지를 성공적으로 삭제하였습니다"),

    ;

    private final String code;
    private final String message;
}
