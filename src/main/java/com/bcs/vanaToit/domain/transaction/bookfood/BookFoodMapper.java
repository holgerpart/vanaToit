package com.bcs.vanaToit.domain.transaction.bookfood;

import com.bcs.vanaToit.domain.shopfood.ShopFood;
import com.bcs.vanaToit.domain.shopfood.ShopFoodDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookFoodMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "userContactFirstName", target = "contact.firstName")
    @Mapping(source = "userContactLastName", target = "contact.lastName")
    @Mapping(source = "shopFoodShopName", target = "shop.name")
    @Mapping(source = "shopFoodFoodName", target = "food.name")
    @Mapping(source = "shopFoodComments", target = "shopFood.comments")
    @Mapping(source = "statusDescription", target = "status.description")
    BookFood bookFoodDtoToBookFood(BookFoodDto bookFoodDto);

    @InheritInverseConfiguration(name = "bookFoodDtoToBookFood")
    BookFoodDto bookFoodToBookFoodDto(BookFood bookFood);

    List<BookFoodDto> toDtos(List<BookFood> bookFoods);

    @InheritConfiguration(name = "bookFoodDtoToBookFood")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFoodFromBookFoodDto(BookFoodDto bookFoodDto, @MappingTarget BookFood bookFood);
}
