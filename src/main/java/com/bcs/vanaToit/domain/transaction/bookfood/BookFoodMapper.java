package com.bcs.vanaToit.domain.transaction.bookfood;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookFoodMapper {
    @Mapping(source = "id", target = "user.id")
    @Mapping(source = "firstName", target = "user.contact.firstName")
    @Mapping(source = "lastName", target = "user.contact.lastName")
    @Mapping(source = "shopName", target = "shopFood.shop.name")
    @Mapping(source = "foodName", target = "shopFood.food.name")
    @Mapping(source = "status", target = "status.description")
    BookFood bookFoodDtoToBookFood(BookFoodDto bookFoodDto);

    @InheritInverseConfiguration(name = "bookFoodDtoToBookFood")
    BookFoodDto bookFoodToBookFoodDto(BookFood bookFood);

    List<BookFoodDto> toDtos(List<BookFood> bookFoods);

    @InheritConfiguration(name = "bookFoodDtoToBookFood")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFoodFromBookFoodDto(BookFoodDto bookFoodDto, @MappingTarget BookFood bookFood);
}
