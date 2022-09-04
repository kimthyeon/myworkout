package com.kan.myworkout.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "legboard")
public class LegBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "le_title")
    private String letitle;

    @Column(name = "le_content")
    private String lecontent;
}
