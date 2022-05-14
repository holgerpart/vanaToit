package com.bcs.vanaToit.domain.shop.city;

import com.bcs.vanaToit.domain.food.type.Type;
import com.bcs.vanaToit.domain.food.type.TypeDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {
    City toEntity(CityDto cityDto);

    CityDto toDto(City city);

    List<CityDto> toDtos(List<City> cities);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCityFromCityDto(CityDto cityDto, @MappingTarget City city);
}
