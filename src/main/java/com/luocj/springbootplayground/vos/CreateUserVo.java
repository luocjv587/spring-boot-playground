package com.luocj.springbootplayground.vos;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CreateUserVo {
    @NotEmpty(message = "name不能为空")
    @Size(min = 5, max = 20)
    private String name;
}
