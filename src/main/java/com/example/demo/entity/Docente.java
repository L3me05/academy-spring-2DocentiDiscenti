package com.example.demo.entity;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@NoArgsConstructor          //genera costruttore senza argomenti
@AllArgsConstructor         //genera costruttore  con tutti i campi degli argomenti
@Data                       //genera getters and setters ha bisogno di un argument constructor
@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false, name = "data_nascita")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")                                 // serve a Spring per interpretare la stringa
    private Date dataNascita;

    @OneToMany(mappedBy = "docente")
    private List<Corso> corsi;



}
