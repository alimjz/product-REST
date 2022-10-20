package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.UserDtoMapper;
import com.digipay.productrest.dto.UserDto;
import com.digipay.productrest.entity.User;
import com.digipay.productrest.repository.UserRepository;
import com.digipay.productrest.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    public UserServiceImpl(UserRepository userRepository, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public User saveUser(UserDto userDto) {
        return userRepository.save(userDtoMapper.dtoToUserMapper(userDto));
    }
}
