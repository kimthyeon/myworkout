package com.kan.myworkout.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private String userid;

    @Column(name = "user_pw")
    private String userpw;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_phone")
    private String userphone;

    @Column(name = "admin")
    private int admin;
}
