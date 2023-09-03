package com.wanted.teamassignment1.controller;

import com.wanted.teamassignment1.dto.PageInfoResponseDto;
import com.wanted.teamassignment1.result.ResultCode;
import com.wanted.teamassignment1.result.ResultResponse;
import com.wanted.teamassignment1.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Stack;

@RestController
@RequiredArgsConstructor
public class PageController {
    private final PageService pageService;

    @RequestMapping(value = "/pages/{pageId}")
    public ResultResponse getPage(@PathVariable("pageId") Long pageId) {
        PageInfoResponseDto pageInfoResponseDto = pageService.findPage(pageId);
        return ResultResponse.of(ResultCode.PAGE_FIND_SUCCESS, pageInfoResponseDto);
    }
}
