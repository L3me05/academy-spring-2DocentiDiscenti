package com.example.demo.util;

import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Docente;

public class DocenteConverter {

    public static DocenteDTO toDTO(Docente docente) {
        DocenteDTO dto = new DocenteDTO(docente.getId(), docente.getNome(), docente.getCognome());
        return dto;
    }

    public static Docente toEntity(DocenteDTO dto) {
        Docente docente= new Docente(dto.getId(), dto.getNome(), dto.getCognome());
        return docente;
    }
}
