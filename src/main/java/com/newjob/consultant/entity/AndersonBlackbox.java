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

}
