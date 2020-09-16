package com.luocj.springbootplayground.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_login_record")
@Data
public class UserLoginRecordEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;
    private String created_at;
    private String updated_at;
}
