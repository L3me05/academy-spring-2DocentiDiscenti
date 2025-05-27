package com.example.demo.mapstruct;

import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.dto.DocenteDTOLight;
import com.example.demo.data.entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteMapper {
    DocenteDTO toDto(Docente docente);
    Docente toEntity(DocenteDTO dto);

}