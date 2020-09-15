package com.luocj.springbootplayground.controllers;
import com.luocj.springbootplayground.vos.IndexVo;

import com.luocj.springbootplayground.vos.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/index")
    public Result index(@Validated IndexVo indexVo){
        return Result.success(indexVo);
    }
}
