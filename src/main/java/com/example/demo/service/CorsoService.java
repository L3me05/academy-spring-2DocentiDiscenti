package com.example.demo.service;

import com.example.demo.data.dto.CorsoDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.mapstruct.CorsoMapper;
import com.example.demo.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorsoService {
    @Autowired
    CorsoRepository corsoRepository;
    @Autowired
    CorsoMapper corsoMapper;

    @EntityGraph(attributePaths = {"docente", "discente"})
    public List<CorsoDTO> findAll() {
        return corsoRepository.findAll().stream()
                .map(corsoMapper::corsoToDto)
                .collect(Collectors.toList());
    }


    public CorsoDTO get(Long id) {
        Corso corso =corsoRepository.findById(id).orElseThrow();
        return corsoMapper.corsoToDto(corso);
    }

    @EntityGraph(attributePaths = {"docente", "discente"})
    public CorsoDTO save(CorsoDTO c){
        Corso corso = corsoMapper.corsoToEntity(c);
        Corso savedCorso = corsoRepository.save(corso);
        return corsoMapper.corsoToDto(savedCorso);
    }

    public void delete(Long id) {
        corsoRepository.deleteById(id);
    }

}
