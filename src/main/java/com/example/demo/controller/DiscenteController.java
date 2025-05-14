package com.example.demo.controller;


import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.entity.Discente;
import com.example.demo.service.DiscenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        List<DiscenteDTO> discenti= discenteService.findAll();
        ModelAndView modelAndView = new ModelAndView("list-discenti");
        modelAndView.addObject("discenti", discenti);
        modelAndView.addObject("nome", "");
        return modelAndView;
    }

    @GetMapping("/cerca")
    public ModelAndView cerca(@RequestParam("nome") String nome) {
        ModelAndView modelAndView=new ModelAndView("list-discenti");
        List<DiscenteDTO> discenti = discenteService.findByName(nome);
       modelAndView.addObject("discenti", discenti);
        return modelAndView;
    }

    //Nuovo
    @GetMapping("/new")
    public ModelAndView showAdd() {
        ModelAndView modelAndView= new ModelAndView("form-discente");
        modelAndView.addObject("discente", new DiscenteDTO());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView create(@ModelAttribute("discente") DiscenteDTO discenteDTO, BindingResult br){
        if(br.hasErrors()) {
            ModelAndView mav= new ModelAndView("form-discente");
            mav.addObject("discente", new DiscenteDTO());
            return mav;
        }
        discenteService.save(discenteDTO);
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
    public ModelAndView update(@PathVariable Long id, @ModelAttribute("discente") DiscenteDTO discenteDTO, BindingResult br ) {
        if(br.hasErrors()) {
            ModelAndView mav=new ModelAndView("form-discente");
            mav.addObject("discente", discenteService.get(id));
            return mav;
        }
        discenteDTO.setId(id);
        discenteService.save(discenteDTO);
        return new ModelAndView("redirect:/discenti/list");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        discenteService.delete(id);
        return new  ModelAndView("redirect:/discenti/list");
    }




}
