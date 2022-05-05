package com.bcs.vanaToit.domain.transaction.bookfood;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookFoodMapper {

    @Mapping(target = "bookedFoodId", source = "id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "firstName", source = "user.contact.firstName")
    @Mapping(target = "lastName", source = "user.contact.lastName")
    @Mapping(target = "status", source = "status.description")
    BookFoodDto toDto(BookFood bookFood);

    List<BookFoodDto> toDtos(List<BookFood> bookFoods);
}
