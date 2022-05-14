package com.bcs.vanaToit.domain.food.type;

import com.bcs.vanaToit.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeService {

    @Resource
    private TypeRepository typeRepository;

    @Resource
    private TypeMapper typeMapper;

    @Resource
    private ValidationService validationService;

    public List<TypeDto> getTypes() {
        return typeMapper.toDtos(typeRepository.findAll()) ;
    }


    public void addType(String typeName) {
        validationService.typeExists(typeName);
        Type type = new Type();
        type.setName(typeName);
        typeRepository.save(type);
    }
}
