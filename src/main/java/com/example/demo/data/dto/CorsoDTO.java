package com.example.demo.data.dto;


import lombok.*;

import java.util.List;

 @Setter
 @Getter
public class CorsoDTO {

    private Long id;
    private String nome;
    private Integer annoAccademico;

    //usato per il form
    private Long docenteId;
    private List<Long> discentiIds;

    //usato per la lista
    private DocenteDTO docente;
    private List<DiscenteDTO> discenti;


}
