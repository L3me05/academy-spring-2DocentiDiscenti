package com.example.demo.modelMapper;

import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Docente;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DocenteModelMapper {
    @Autowired
    ModelMapper modelMapper;
    
    public DocenteDTO docenteToDto (Docente docente) {
        return modelMapper.map(docente, DocenteDTO.class);
    }

    public Docente docenteToEntity (DocenteDTO docenteDTO) {
        return modelMapper.map(docenteDTO, Docente.class);
    }
    

}
