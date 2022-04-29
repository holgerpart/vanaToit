package com.bcs.vanaToit.service.food;

import com.bcs.vanaToit.domain.food.type.Type;
import lombok.Data;

@Data
public class ArticleRequest {
    private String articleName;
    private String typeName;
}
