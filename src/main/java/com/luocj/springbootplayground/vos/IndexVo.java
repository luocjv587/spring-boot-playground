package com.luocj.springbootplayground.vos;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

@Data
public class IndexVo {
    @NotEmpty(message = "name不能为空")
    private String name;

    @Range(min = 0, max = 100, message = "age不能大于100小于0")
    private int age;
}
