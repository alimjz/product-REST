package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.UserDtoMapper;
import com.digipay.productrest.model.dto.UserDto;
import com.digipay.productrest.model.entity.Role;
import com.digipay.productrest.model.entity.User;
import com.digipay.productrest.repository.UserRepository;
import com.digipay.productrest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDtoMapper dtoUserMapper;

    public UserServiceImpl(UserRepository userRepository, UserDtoMapper dtoUserMapper) {
        this.userRepository = userRepository;
        this.dtoUserMapper = dtoUserMapper;
    }

    @Override
    public User saveUser(UserDto userDto) {
        return userRepository.save(dtoUserMapper.dtoToUserMapper(userDto));
    }

    @Override
    public Optional<User> findUserByUserId(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> findAllUserPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList = userRepository.findByAccount(username);

        log.info(userList.size() + " Users found.");
        if (userList.isEmpty()) {
            throw new UsernameNotFoundException("Incorrect Username / Password supplied!");
        }

        User user = userList.get(0);
        List<Role> roles = new ArrayList<>();
        roles.add(user.getRole());
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getUserId())
                .authorities(roles.get(0).toString())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
