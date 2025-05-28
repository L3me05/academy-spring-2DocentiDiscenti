package com.example.demo.repository;



import com.example.demo.data.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
    @Query("SELECT COUNT(d) FROM Docente d")
    Long contaDocenti();

    @Query("SELECT d FROM Docente d WHERE d.nome = :nome")
    List<Docente> findByNome(@Param("nome") String nome);

}
