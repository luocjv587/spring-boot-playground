package com.luocj.springbootplayground.controllers;

import com.luocj.springbootplayground.entities.UserEntity;
import com.luocj.springbootplayground.repositories.UserRepository;
import com.luocj.springbootplayground.vos.CreateUserVo;
import com.luocj.springbootplayground.vos.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user/all")
    public Result getAllUser(){
        return Result.success(userRepository.findAll());
    }

    @PostMapping("/user/add")
    public Result addUser(@Validated CreateUserVo createUserVo){
        UserEntity n = new UserEntity();
        n.setName(createUserVo.getName());
        userRepository.save(n);
        return Result.success(userRepository.findAll());
    }
}
