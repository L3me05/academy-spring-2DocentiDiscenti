package com.example.demo.controller;

import com.example.demo.entity.Docente;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/docenti")
public class DocenteController {

    @Autowired
    DocenteService docenteService;

    // LISTA
    @GetMapping("/lista")
    public String list(Model model) {
        List<Docente> docenti = new ArrayList<>();
        docenti = docenteService.findAll();
        model.addAttribute("docenti", docenti);
        return "list-docenti";
    }

    // FORM NUOVO
    @GetMapping("/new")
    public String showAdd(Model model) {
        model.addAttribute("docente", new Docente());
        return "form-docente";
    }

    // SALVA NUOVO
    @PostMapping
    public String create(@ModelAttribute("docente") Docente docente, BindingResult br) {
        if (br.hasErrors()) return "form-docente";
        docenteService.save(docente);
        return "redirect:/docenti/lista";
    }

    // FORM EDIT
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {                                //@PathVariable Long id: estrae l’id dalla URL.
        model.addAttribute("docente", docenteService.get(id));                      //docenteService.get(id): recupera il docente con quell’id dal database.
        return "form-docente";                                                                  //model.addAttribute(...): mette il docente nel Model così da riempire il form (form:form) con i suoi dati.
    }

    // AGGIORNA
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("docente") Docente docente, BindingResult br) {                 //@ModelAttribute("docente"): Spring crea un oggetto Docente con i valori del form.
        if (br.hasErrors()) return "form-docente";
        docente.setId(id);                                                                                                  //docente.setId(id): imposta l’ID corretto (serve se non è passato nel form).
        docenteService.save(docente);                                                                           //salva e aggiorna il db
        return "redirect:/docenti/lista";
    }

    // DELETE
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        docenteService.delete(id);
        return "redirect:/docenti/lista";
    }








}

