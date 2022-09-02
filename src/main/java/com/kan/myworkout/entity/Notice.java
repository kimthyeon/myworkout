package com.kan.myworkout.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nt_title")
    private String nttitle;

    @Column(name = "nt_content")
    private String ntcontent;
}
