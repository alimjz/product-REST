package com.digipay.productrest.conf.mapper.impl;

import com.digipay.productrest.conf.mapper.UserDtoMapper;
import com.digipay.productrest.dto.UserDto;
import com.digipay.productrest.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-20T21:07:28+0330",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_341 (Oracle Corporation)"
)
@Component
public class UserDtoMapperImpl implements UserDtoMapper {

    @Override
    public User dtoToUserMapper(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDto.getUserId() );
        user.setUserName( userDto.getUserName() );
        user.setUserLastName( userDto.getUserLastName() );
        user.setRole( userDto.getRole() );
        user.setContact( userDto.getContact() );

        return user;
    }

    @Override
    public UserDto userToDtoMapper(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserId( user.getUserId() );
        userDto.setUserName( user.getUserName() );
        userDto.setUserLastName( user.getUserLastName() );
        userDto.setRole( user.getRole() );
        userDto.setContact( user.getContact() );

        return userDto;
    }
}
