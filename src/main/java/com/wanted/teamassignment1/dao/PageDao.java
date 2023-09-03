package com.wanted.teamassignment1.dao;

import com.wanted.teamassignment1.dto.PageDto;
import java.util.List;

public interface PageDao {
    PageDto findById(Long pageId);
    List<PageDto> findSubPages(Long pageId);
}
