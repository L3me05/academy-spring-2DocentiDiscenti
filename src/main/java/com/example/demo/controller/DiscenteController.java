package com.example.demo.controller;


import com.example.demo.entity.Discente;
import com.example.demo.entity.Docente;
import com.example.demo.service.DiscenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/discenti")
public class DiscenteController {

    @Autowired
    DiscenteService discenteService;

    //Lista
    @GetMapping("/list")
    public ModelAndView list() {
        List<Discente> discenti= discenteService.findAll();
        ModelAndView modelAndView = new ModelAndView("list-discenti");
        modelAndView.addObject("discenti", discenti);
        return modelAndView;
    }

    //Nuovo
    @GetMapping("/new")
    public ModelAndView showAdd() {
        ModelAndView modelAndView= new ModelAndView("form-discente");
        modelAndView.addObject("discente", new Discente());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView create(@ModelAttribute("discente") Discente discente, BindingResult br){
        if(br.hasErrors()) {
            ModelAndView mav= new ModelAndView("form-discente");
            mav.addObject("discente", new Discente());
            return mav;
        }
        discenteService.save(discente);
        return new ModelAndView("redirect:/discenti/list");
    }


    //Modifica

    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable Long id) {
        ModelAndView modelAndView=new ModelAndView("form-discente");
        modelAndView.addObject("discente", discenteService.get(id));
        return modelAndView;
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Long id, @ModelAttribute("discente") Discente discente, BindingResult br ) {
        if(br.hasErrors()) {
            ModelAndView mav=new ModelAndView("form-discente");
            mav.addObject("discente", discenteService.get(id));
            return mav;
        }
        discente.setId(id);
        discenteService.save(discente);
        return new ModelAndView("redirect:/discenti/list");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        discenteService.delete(id);
        return new  ModelAndView("redirect:/discenti/list");
    }




}
