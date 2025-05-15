package com.example.demo.service;

import com.example.demo.modelMapper.DiscenteModelMapper;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Discente;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.repository.DiscenteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscenteService {
    @Autowired
    DiscenteRepository discenteRepository;

    @Autowired
    CorsoRepository corsoRepository;

    @Autowired
    DiscenteModelMapper mapper;

    public List<DiscenteDTO> findAll() {
        return discenteRepository.findAll().stream()
                .map(discente -> mapper.discenteToDto(discente))
                .collect(Collectors.toList());
    }

    public DiscenteDTO get(Long id) {
        Discente discente = discenteRepository.findById(id).orElseThrow();
        return mapper.discenteToDto(discente);
    }

    public DiscenteDTO save(DiscenteDTO d){
        Discente discente = mapper.discenteToEntity(d);
        Discente savedDiscente=discenteRepository.save(discente);
        return mapper.discenteToDto(savedDiscente);
    }

    @Transactional
    public void delete(Long id){
        Discente discente = discenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Discente non trovato"));

        List<Corso> corsi = corsoRepository.findByDiscente(discente);
        for (Corso corso : corsi) {
            corso.getDiscenti().remove(discente);
        }
        corsoRepository.saveAll(corsi);

        discenteRepository.delete(discente);

    }


    public List<DiscenteDTO> findByName(String nome) {
        return discenteRepository.findByName(nome).stream()
                .map(discente -> mapper.discenteToDto(discente))
                .collect(Collectors.toList());
    }
}
