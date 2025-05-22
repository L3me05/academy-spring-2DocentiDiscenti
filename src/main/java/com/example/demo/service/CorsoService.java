package com.example.demo.service;

import com.example.demo.data.dto.CorsoDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Discente;
import com.example.demo.mapstruct.CorsoMapper;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.repository.DiscenteRepository;
import com.example.demo.repository.DocenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.Collections; // Import per Collections.emptyList()
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream; // Import per Stream

@Service
public class CorsoService {

    @Autowired
    CorsoRepository corsoRepository;
    @Autowired
    CorsoMapper corsoMapper;
    @Autowired
    private DocenteRepository docenteRepository;
    @Autowired
    private DiscenteRepository discenteRepository;



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

        if(c.getDocenteDTOLight()!=null) {
            corso.setDocente(docenteRepository.findByNomeAndCognome(c.getDocenteDTOLight().getNome(), c.getDocenteDTOLight().getCognome()));
        }

        if(c.getDiscentiDTOLight()!=null && !c.getDiscentiDTOLight().isEmpty()) {
            List<Discente> discentiAssociati = c.getDiscentiDTOLight().stream()
                .flatMap(dtoLight -> {
                    List<Discente> trovati = discenteRepository.findByNomeAndCognome(dtoLight.getNome(), dtoLight.getCognome());
                    return trovati == null ? Stream.empty() : trovati.stream();
                })
                .collect(Collectors.toList());
            corso.setDiscenti(discentiAssociati);
        }   else {
            corso.setDiscenti(Collections.emptyList());
        }

        Corso savedCorso = corsoRepository.save(corso);
        return corsoMapper.corsoToDto(savedCorso);
    }

    public CorsoDTO update(Long id, CorsoDTO corsoDTO) {
        Corso corso=corsoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Corso non trovato"));
        if(corsoDTO.getNome()!=null) corso.setNome(corsoDTO.getNome());
        if (corsoDTO.getAnnoAccademico()!=null) corso.setAnnoAccademico(corsoDTO.getAnnoAccademico());
        if(corsoDTO.getDocenteDTOLight()!=null) corso.setDocente(docenteRepository.findByNomeAndCognome(corsoDTO.getDocenteDTOLight().getNome(), corsoDTO.getDocenteDTOLight().getCognome()));
        if (corsoDTO.getDiscentiDTOLight()!=null && !corsoDTO.getDiscentiDTOLight().isEmpty()) {
            List<Discente> discentiAssociati = corsoDTO.getDiscentiDTOLight().stream()
                    .flatMap(dtoLight -> {
                        List<Discente> trovati = discenteRepository.findByNomeAndCognome(dtoLight.getNome(), dtoLight.getCognome());
                        return trovati == null ? Stream.empty() : trovati.stream();
                    })
                    .collect(Collectors.toList());
            corso.setDiscenti(discentiAssociati);
        }   else {
            corso.setDiscenti(Collections.emptyList());
        }
        Corso savedCorso = corsoRepository.save(corso);
        return corsoMapper.corsoToDto(savedCorso);
    }

    public void delete(Long id) {
        corsoRepository.deleteById(id);
    }


}