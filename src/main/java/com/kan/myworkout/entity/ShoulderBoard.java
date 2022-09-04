package com.kan.myworkout.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shoulderboard")
public class ShoulderBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sh_title")
    private String shtitle;

    @Column(name = "sh_content")
    private String shcontent;
}
