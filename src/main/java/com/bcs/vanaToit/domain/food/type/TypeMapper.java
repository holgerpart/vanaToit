package com.bcs.vanaToit.domain.food.type;

import com.bcs.vanaToit.domain.shopfood.ShopFood;
import com.bcs.vanaToit.domain.shopfood.ShopFoodDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TypeMapper {
    Type toEntity(TypeDto typeDto);

    TypeDto toDto(Type type);

    List<TypeDto> toDtos(List<Type> stock);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTypeFromTypeDto(TypeDto typeDto, @MappingTarget Type type);
}
