package com.example.demo.controller;

import com.example.demo.entity.Corso;
import com.example.demo.service.CorsoService;
import com.example.demo.service.DiscenteService;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/corsi")
public class CorsoController {
    @Autowired
    CorsoService corsoService;
    DocenteService docenteService;
    DiscenteService discenteService;

    //lista
    @GetMapping("/list")
    public String list(Model model) {
        List<Corso> corsi= corsoService.findAll();
        model.addAttribute("corsi", corsi);
        return "corso-list";
        }
}
