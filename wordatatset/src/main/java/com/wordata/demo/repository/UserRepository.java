package com.wordata.demo.repository;

import com.wordata.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findOneByLoginId(String loginID);
}
