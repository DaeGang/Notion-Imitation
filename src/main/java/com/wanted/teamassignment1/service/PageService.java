package com.wanted.teamassignment1.service;

import com.wanted.teamassignment1.dao.PageDao;
import com.wanted.teamassignment1.dto.PageDto;
import com.wanted.teamassignment1.dto.PageInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PageService {
    private final PageDao pageDao;

    public PageInfoResponseDto findPage(Long pageId) {
        PageDto pageInfo = pageDao.findById(pageId);
        List<PageDto> subPages = pageDao.findSubPages(pageId);
        List<String> breadcrumbs = getBreadcrumbs(pageId);

        return PageInfoResponseDto.of(pageInfo, subPages, breadcrumbs);
    }

    private List<String> getBreadcrumbs(Long pageId) {
        List<String> breadcrumbs = new ArrayList<>();
        while (pageId != null) {
            PageDto page = pageDao.findById(pageId);
            breadcrumbs.add(page.getTitle());
            pageId = pageDao.findById(pageId).getParentPage();
        }

        Collections.reverse(breadcrumbs);
        return breadcrumbs;
    }
}
