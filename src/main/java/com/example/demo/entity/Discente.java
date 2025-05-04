package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "discente")
public class Discente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private Integer matricola;

    @Column(nullable = false, name = "età")
    private Integer eta;

    @Column(nullable = false, name= "città_residenza")
    private String cittaResidenza;

//    @ManyToMany
//    @JoinTable(name = "corso_discente",
//                joinColumns = @JoinColumn(name = "id_discente"),
//                inverseJoinColumns = @JoinColumn(name = "id_corso"))
//    private Set<Corso> corsi=new HashSet<>();

    @ManyToMany(mappedBy = "discenti")
    private List<Corso> corsi;
}
