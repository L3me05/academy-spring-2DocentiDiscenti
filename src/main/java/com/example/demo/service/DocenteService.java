package com.example.demo.service;

import com.example.demo.util.DocenteConverter;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Docente;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.repository.DocenteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocenteService {


    @Autowired
    DocenteRepository docenteRepository;

    @Autowired
    CorsoRepository corsoRepository;

    public List<DocenteDTO> findAll() {
        return docenteRepository.findAll().stream()
                .map(DocenteConverter::toDTO)
                .collect(Collectors.toList());
    }

    public DocenteDTO get(Long id) {
        Docente docente =docenteRepository.findById(id)
                .orElseThrow();
        return DocenteConverter.toDTO(docente);
    }

    public DocenteDTO save(DocenteDTO d) {
        Docente docente = DocenteConverter.toEntity(d);
        Docente savedDocente = docenteRepository.save(docente);
        return DocenteConverter.toDTO(savedDocente);
    }

    public DocenteDTO update(Long id, DocenteDTO d ) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Docente non trovato"));
        if(d.getNome()!=null) docente.setNome(d.getNome());
        if(d.getCognome()!=null) docente.setCognome(d.getCognome());
        Docente savedDocente = docenteRepository.save(docente);
        return DocenteConverter.toDTO(savedDocente);
    }

    @Transactional
    public void delete(Long id) {
        // Prima recuperi il docente
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Docente non trovato"));

        // Setti a null tutti i corsi che lo referenziano
        List<Corso> corsi = corsoRepository.findByDocente(docente);
        for (Corso corso : corsi) {
            corso.setDocente(null);
        }
        corsoRepository.saveAll(corsi);

        // Poi elimini il docente
        docenteRepository.delete(docente);
    }


    public Long contaDocenti() {
        return docenteRepository.contaDocenti();
    }

    public List<DocenteDTO> findbyNome(String nome) {
        return docenteRepository.findByNome(nome).stream()
                .map(DocenteConverter::toDTO)
                .collect(Collectors.toList());
    }
}
