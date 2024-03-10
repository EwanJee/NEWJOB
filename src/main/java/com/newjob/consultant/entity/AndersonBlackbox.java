package com.newjob.consultant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "anderson_blackbox")
@Entity
public class AndersonBlackbox {
    @Id
    @Column(name = "b_number")
    private int bNumber;
    @Column(name = "type")
    private String type;
    @Column(name = "field_a")
    private String fieldA;
    @Column(name = "field_b")
    private String fieldB;
    @Column(name = "field_c")
    private String fieldC;
    @Column(name = "field_d")
    private String fieldD;
    @Column(name = "field_e")
    private String fieldE;
    @Column(name = "field_f")
    private String fieldF;
}
