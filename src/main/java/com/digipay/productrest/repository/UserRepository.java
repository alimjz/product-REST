package com.digipay.productrest.repository;

import com.digipay.productrest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
