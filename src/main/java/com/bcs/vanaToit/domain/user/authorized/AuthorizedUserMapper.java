package com.bcs.vanaToit.domain.user.authorized;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuthorizedUserMapper {


    @Mapping(target = "shopId", source = "shop.id")
    @Mapping(target = "shopName", source = "shop.name")
    @Mapping(target = "city", source = "shop.profile.city.name")
    AuthorizedUserDto toDto(AuthorizedUser entity);

    List<AuthorizedUserDto> toDtos(List<AuthorizedUser> entity);



    @InheritConfiguration(name = "authorizedUserDtoToAuthorizedUser")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAuthorizedUserFromAuthorizedUserDto(AuthorizedUserDto authorizedUserDto, @MappingTarget AuthorizedUser authorizedUser);
}
