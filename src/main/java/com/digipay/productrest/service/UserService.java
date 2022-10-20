package com.digipay.productrest.service;

import com.digipay.productrest.dto.UserDto;
import com.digipay.productrest.entity.User;

public interface UserService {
    User saveUser(UserDto userDto);
}
