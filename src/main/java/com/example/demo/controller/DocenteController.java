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
@RequestMapping("/docenti")                     //tutti gli endpoint dentro questa classe avranno come prefisso /docenti
public class DocenteController {

    @Autowired                                  //Inietta automaticamente un'istanza di DocenteService
    DocenteService docenteService;

    // LISTA
    @GetMapping("/lista")                       //Questa annotazione dice a Spring: "Se arriva una richiesta GET all’URL /lista, esegui questo metodo.
    public String list(Model model) {                   //Il parametro Model model serve per passare dati alla vista (JSP)
        List<Docente> docenti = new ArrayList<>();
        docenti = docenteService.findAll();                         //Aggiunge la lista al modello per usarla nella JSP.
        model.addAttribute("docenti", docenti);         // Aggiunge al modello la lista dei docenti con il nome "docenti".
        return "list-docenti";
    }

    // FORM NUOVO
    @GetMapping("/new")                                     //Questo metodo risponde a una richiesta GET all’URL /docenti/new
    public String showAdd(Model model) {                                //restituisce il nome della vista JSP e accetta un Model per passare dati al frontend.
        model.addAttribute("docente", new Docente());          //Crea un oggetto vuoto di tipo Docente e lo aggiunge al modello con il nome "docente". new Docente(): Crea un oggetto vuoto per collegarlo al form con form:form.
        return "form-docente";
    }

    // SALVA NUOVO
    @PostMapping                                                            //indica che questo metodo gestisce le richieste POST (invio di un form) all’URL /docenti                               //@PostMapping: Gestisce l’invio del form.
    public String create(@ModelAttribute("docente") Docente  docente, BindingResult br) {            //@ModelAttribute("docente"): Prende i dati del form e li converte in un oggetto Docente
        if (br.hasErrors()) return "form-docente";                                           //Se ci sono errori nei dati inviati, non salva, ma torna al form (form-docente.jsp) per far correggere gli errori all’utente.
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
    @GetMapping("/{id}/delete")                              //@GetMapping("/{id}/delete"): Mappa ad esempio /docenti/5/delete.
    public String delete(@PathVariable Long id) {
        docenteService.delete(id);
        return "redirect:/docenti/lista";
    }








}

