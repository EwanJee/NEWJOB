package com.newjob.consultant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.SQLInsert;

@Entity
public class MrAndersonQuestion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
