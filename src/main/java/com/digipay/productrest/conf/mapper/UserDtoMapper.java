package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.model.dto.UserDto;
import com.digipay.productrest.model.entity.User;

//@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    User dtoToUserMapper(UserDto userDto);

}
