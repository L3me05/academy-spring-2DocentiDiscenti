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

//    @ManyToMany
//    @JoinTable(name = "corso_discente",
//                joinColumns = @JoinColumn(name = "id_discente"),
//                inverseJoinColumns = @JoinColumn(name = "id_corso"))
//    private Set<Corso> corsi=new HashSet<>();

    @ManyToMany(mappedBy = "discenti")
    private List<Corso> corsi;

    public Discente(Long id, String nome, String cognome, Integer matricola, String cittaResidenza) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.cittaResidenza = cittaResidenza;
    }

    //Il metodo equals di java considera uguali due oggetti se hanno lo stesso indirizzo di memoria, così li consideriamo uguali se lo sono logicamente e non fisicamente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discente)) return false;
        Discente that = (Discente) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
