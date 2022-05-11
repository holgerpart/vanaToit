package com.bcs.vanaToit.domain.food.type;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeService {

    @Resource
    private TypeRepository typeRepository;

    @Resource
    private TypeMapper typeMapper;

    public List<TypeDto> getTypes() {
        return typeMapper.toDtos(typeRepository.findAll()) ;
    }
}
