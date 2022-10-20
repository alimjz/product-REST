package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.dto.UserDto;
import com.digipay.productrest.entity.User;

//@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    User dtoToUserMapper(UserDto userDto);

    UserDto userToDtoMapper(User user);
}
