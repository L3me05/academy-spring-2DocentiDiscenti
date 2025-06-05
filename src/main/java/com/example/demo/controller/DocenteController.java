package com.example.demo.controller;

import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docenti")
public class DocenteController {

    @Autowired
    DocenteService docenteService;

    // LISTA
    @GetMapping("/list")
    public List<DocenteDTO> list() {
        List<DocenteDTO> docenti = docenteService.findAll();
        Long numeroDocenti = docenteService.contaDocenti();
        return docenti;
    }
    @GetMapping("/present")
    public boolean existsById(@RequestParam Long id) {
        return docenteService.existsById(id);
    }

    @GetMapping("/findById")
    public DocenteDTO findById(@RequestParam Long id) {
        return docenteService.findById(id);
    }

    @GetMapping("/findIdByNomeAndCognome")
    public Long findIdByNomeAndCognome(@RequestParam String nome, @RequestParam String cognome) {
        return docenteService.findIdByNomeAndCognome(nome, cognome);
    }


    @GetMapping("/cerca")
    public List<DocenteDTO> cerca(@RequestParam String nome) {
        return docenteService.findbyNome(nome);
    }

    @PostMapping("/createAndReturnId")
    public Long createAndReturnId(@RequestBody DocenteDTO docenteDTO) {
        return docenteService.createAndReturnId(docenteDTO);
    }

    // SALVA NUOVO
    @PostMapping
    public DocenteDTO create(@RequestBody DocenteDTO docenteDTO) {
        return docenteService.save(docenteDTO);

    }

    //update
    @PutMapping("/{id}")
    public DocenteDTO update(@PathVariable Long id, @RequestBody DocenteDTO docenteDTO) {
        return docenteService.update(id, docenteDTO);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        docenteService.delete(id);
    }




}

