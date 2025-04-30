package com.example.demo.controller;


import com.example.demo.entity.Discente;
import com.example.demo.entity.Docente;
import com.example.demo.service.DiscenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/discenti")
public class DiscenteController {

    @Autowired
    DiscenteService discenteService;

    //Lista
    @GetMapping("/list")
    public String list(Model model) {
        List<Discente> discenti= discenteService.findAll();
        model.addAttribute("discenti", discenti);
        return "list-discenti";
    }

    //Nuovo
    @GetMapping("/new")
    public String showAdd(Model model) {
        model.addAttribute("discente", new Discente());
        return "form-discente";
    }

    @PostMapping
    public String create(@ModelAttribute("discente") Discente discente, BindingResult br){
        if(br.hasErrors()) return "form-discente";
        discenteService.save(discente);
        return "redirect:/discente/list";
    }





}
