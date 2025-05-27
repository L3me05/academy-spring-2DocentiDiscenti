package com.example.demo.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "corsi")
@Entity
@Table(name = "discente")
public class Discente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true)
    private String cognome;

    @Column(nullable = true)
    private Integer matricola;

    @Column(nullable = true, name = "età")
    private Integer eta;

    @Column(nullable = true, name= "città_residenza")
    private String cittaResidenza;

    @ManyToMany(mappedBy = "discenti")
    private List<Corso> corsi;



}
