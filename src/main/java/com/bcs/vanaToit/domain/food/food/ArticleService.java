package com.bcs.vanaToit.domain.food.food;

import com.bcs.vanaToit.domain.food.type.Type;
import com.bcs.vanaToit.domain.food.type.TypeRepository;
import com.bcs.vanaToit.service.food.ArticleRequest;
import com.bcs.vanaToit.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleService {

    @Resource
    private FoodRepository foodRepository;

    @Resource
    private ValidationService validationService;

    @Resource
    private TypeRepository typeRepository;

    public void addArticle(ArticleRequest request) {
        validationService.articleExists(request);
        Food article = new Food();
        Type type = typeRepository.findType(request.getTypeName());
        article.setName(request.getArticleName());
        article.setType(type);
        foodRepository.save(article);
    }

//    public void addA

}
