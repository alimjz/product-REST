package com.digipay.productrest.service;

import com.digipay.productrest.model.dto.UserDto;
import com.digipay.productrest.model.entity.User;

public interface UserService {
    User saveUser(UserDto userDto);
}
