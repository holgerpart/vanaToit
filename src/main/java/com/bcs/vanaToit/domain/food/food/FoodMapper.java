package com.bcs.vanaToit.domain.food.food;

import com.bcs.vanaToit.domain.shop.shop.Shop;
import com.bcs.vanaToit.domain.shop.shop.ShopDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FoodMapper {
    Food toEntity(FoodDto foodDto);

    FoodDto toDTO(Food food);

    List<FoodDto> toDtos(List<Food> shops);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFoodFromFoodDto(FoodDto foodDto, @MappingTarget Food food);
}
