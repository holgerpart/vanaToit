package com.bcs.vanaToit.domain.shopfood;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShopFoodMapper {
    @Mapping(source = "shopId", target = "shop.id")
    @Mapping(source = "shopName", target = "shop.name")
    @Mapping(source = "foodId", target = "food.id")
    @Mapping(source = "foodName", target = "food.name")
    @Mapping(source = "unitId", target = "unit.id")
    @Mapping(source = "unitName", target = "unit.name")
    ShopFood shopFoodDtoToShopFood(ShopFoodDto shopFoodDto);

    @InheritInverseConfiguration(name = "shopFoodDtoToShopFood")
    ShopFoodDto shopFoodToShopFoodDto(ShopFood shopFood);

    List<ShopFoodDto> toDtos(List<ShopFood> stock);

    @InheritConfiguration(name = "shopFoodDtoToShopFood")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateShopFoodFromShopFoodDto(ShopFoodDto shopFoodDto, @MappingTarget ShopFood shopFood);
}
