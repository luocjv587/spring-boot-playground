package com.luocj.springbootplayground.controllers;

import com.luocj.springbootplayground.entities.UserEntity;
import com.luocj.springbootplayground.repositories.UserRepository;
import com.luocj.springbootplayground.utils.RedisUtil;
import com.luocj.springbootplayground.vos.CreateUserVo;
import com.luocj.springbootplayground.vos.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Resource
    private RedisUtil redisUtil;

    @GetMapping("/user/all")
    public Result getAllUser(){
        return Result.success(redisUtil.get("users"));
    }

    @PostMapping("/user/add")
    public Result addUser(@Validated CreateUserVo createUserVo){
        UserEntity n = new UserEntity();
        n.setName(createUserVo.getName());
        userRepository.save(n);

        redisUtil.set("users",userRepository.findAll());
        return Result.success(redisUtil.get("users"));
    }


}
