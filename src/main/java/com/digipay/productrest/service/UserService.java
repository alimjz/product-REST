package com.digipay.productrest.service;

import com.digipay.productrest.model.dto.UserDto;
import com.digipay.productrest.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    User saveUser(UserDto userDto);

    Optional<User> findUserByUserId(String id);

    Page<User> findAllUserPageable(Pageable pageable);
}
