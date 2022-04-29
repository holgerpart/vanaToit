package com.bcs.vanaToit.service.food;

import com.bcs.vanaToit.domain.food.food.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FoodService {

    @Resource
    private ArticleService articleService;

    public void addArticle(ArticleRequest request) {
        articleService.addArticle(request);
    }
}
