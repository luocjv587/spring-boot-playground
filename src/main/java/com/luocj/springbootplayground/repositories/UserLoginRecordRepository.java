package com.luocj.springbootplayground.repositories;

import com.luocj.springbootplayground.entities.UserEntity;
import com.luocj.springbootplayground.entities.UserLoginRecordEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserLoginRecordRepository extends CrudRepository<UserLoginRecordEntity, Integer> {

}
