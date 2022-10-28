package com.digipay.productrest.repository;

import com.digipay.productrest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByAccount(String account);
}
