package com.kan.myworkout.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "backboard")
public class BackBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ba_title")
    private String batitle;

    @Column(name = "ba_content")
    private String bacontent;
}
