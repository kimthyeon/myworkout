package com.kan.myworkout.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "freeboard")
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fr_title")
    private String frtitle;

    @Column(name = "fr_content")
    private String frcontent;
}
