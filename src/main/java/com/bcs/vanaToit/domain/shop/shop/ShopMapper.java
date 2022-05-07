package com.bcs.vanaToit.domain.shop.shop;

import com.bcs.vanaToit.domain.shopfood.ShopFood;
import com.bcs.vanaToit.domain.shopfood.ShopFoodDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShopMapper {
    @Mapping(source = "aadress", target = "profile.aadress")
    @Mapping(source = "telNumber", target = "profile.telNumber")
    @Mapping(source = "cityName", target = "profile.city.name")
    Shop toEntity(ShopDto shopDto);

    @InheritInverseConfiguration(name = "toEntity")
    ShopDto toDto(Shop shop);

    List<ShopDto> toDtos(List<Shop> shops);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateShopFromShopDto(ShopDto shopDto, @MappingTarget Shop shop);
}
