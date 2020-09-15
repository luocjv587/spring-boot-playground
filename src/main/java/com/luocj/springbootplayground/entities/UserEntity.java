package com.luocj.springbootplayground.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(nullable = false,length = 50)
    private String password;
}
