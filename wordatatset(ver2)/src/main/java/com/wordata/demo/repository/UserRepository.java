package com.wordata.demo.repository;

import com.wordata.demo.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findOneByLoginId(String loginID);
}
