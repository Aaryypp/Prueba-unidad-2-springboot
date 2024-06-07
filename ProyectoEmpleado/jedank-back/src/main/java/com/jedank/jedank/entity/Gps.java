package com.jedank.jedank.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table
public class Gps implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private Long id_gps;

    @Column(nullable = false,length = 30)
    private String aaa;


}
