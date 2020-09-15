package com.luocj.springbootplayground.vos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class LoginVo {
    @NotEmpty(message = "username不能为空")
    @Size(min = 5, max = 20)
    private String username;

    @NotEmpty(message = "password不能为空")
    @Size(min = 5, max = 20)
    private String password;
}
