package com.example.demo.mapstruct;

import com.example.demo.data.dto.CorsoDTO;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Discente;
import com.example.demo.data.entity.Docente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CorsoMapper {

    @Mapping(target = "id", source = "id")
    CorsoDTO corsoToDto(Corso corso);

    @Mapping(target = "id", source = "id")
    Corso corsoToEntity(CorsoDTO corsoDTO);

    DocenteDTO docenteToDto(Docente docente);

    Docente docenteToEntity(DocenteDTO docenteDTO);

    List<DiscenteDTO> listDiscentiToDto(List<Discente> discenti);

    List<Discente> listDiscentiToEntity(List<DiscenteDTO> discentiDTO);
}
