package com.elysiaptr.cemenghuiweb.web.service;

import com.elysiaptr.cemenghuiweb.web.po.News;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsService {
    News saveNews(News news);

    News updateNews(Long id, News newsDetails);

    void deleteNews(Long id);

    News getNewsById(Long id);


    List<News> getAllNews();

    Page<News> getNewsByPage(int page, int size);
}