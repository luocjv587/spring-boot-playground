package com.luocj.springbootplayground.repositories;

import com.luocj.springbootplayground.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
