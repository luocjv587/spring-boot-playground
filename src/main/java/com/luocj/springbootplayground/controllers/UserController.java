package com.luocj.springbootplayground.controllers;

import com.luocj.springbootplayground.configs.JwtConfig;
import com.luocj.springbootplayground.entities.UserEntity;
import com.luocj.springbootplayground.repositories.UserRepository;
import com.luocj.springbootplayground.utils.RedisUtil;
import com.luocj.springbootplayground.vos.CreateUserVo;
import com.luocj.springbootplayground.vos.LoginVo;
import com.luocj.springbootplayground.vos.Result;
import com.luocj.springbootplayground.vos.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private JwtConfig jwtConfig ;

    @GetMapping("/user/all")
    public Result getAllUser(){
        return Result.success(redisUtil.get("users"));
    }

    @PostMapping("/user/add")
    public Result addUser(@Validated CreateUserVo createUserVo){
        UserEntity n = new UserEntity();
        n.setName(createUserVo.getName());
        n.setUsername(createUserVo.getUsername());
        n.setPassword(createUserVo.getPassword());
        userRepository.save(n);

        redisUtil.set("users",userRepository.findAll());
        return Result.success(redisUtil.get("users"));
    }

    @PostMapping("/user/login")
    public Result userLogin(@Validated LoginVo loginVo){
        UserEntity n = userRepository.findByUsername(loginVo.getUsername());
        if (n == null || !n.getPassword().equals(loginVo.getPassword())){
            return Result.failure(ResultCode.FAILURE,"登录失败") ;
        }
        String userId = n.getId().toString();
        String token = jwtConfig.createToken(userId) ;
        JSONObject json = new JSONObject();
        if (!StringUtils.isEmpty(token)) {
            json.put("token",token) ;
        }
        return Result.success(json) ;
    }


}
