package com.example.demo.modelMapper;

import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.entity.Discente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiscenteModelMapper {
    @Autowired
    ModelMapper modelMapper;

    public DiscenteDTO discenteToDto(Discente discente) {
        return modelMapper.map(discente, DiscenteDTO.class);
    }

    public Discente discenteToEntity(DiscenteDTO discenteDTO) {
        return modelMapper.map(discenteDTO, Discente.class);
    }
}
