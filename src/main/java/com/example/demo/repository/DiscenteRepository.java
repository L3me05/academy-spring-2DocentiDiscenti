package com.example.demo.repository;

import com.example.demo.data.entity.Discente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscenteRepository extends JpaRepository<Discente, Long> {
    @Query("SELECT d FROM Discente d WHERE d.nome=:nome")
    List<Discente> findByName(String nome);

}

