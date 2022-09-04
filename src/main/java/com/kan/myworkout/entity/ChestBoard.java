package com.kan.myworkout.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="chestboard")
public class ChestBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ch_title")
    private String chtitle;

    @Column(name = "ch_content")
    private String chcontent;
}
