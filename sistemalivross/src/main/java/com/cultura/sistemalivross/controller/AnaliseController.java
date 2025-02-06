package com.cultura.sistemalivross.controller;

import com.cultura.sistemalivross.model.Analise;
import com.cultura.sistemalivross.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnaliseController {

    @Autowired // Injeção do AnaliseService
    private AnaliseService analiseService;

    @GetMapping("/livros/{id}/analise")
    public String adicionarAnalise(@PathVariable Long id, Model model) {
        model.addAttribute("livroId", id);
        return "adicionar-analise";
    }

    @PostMapping("/livros/{id}/analise")
    public String salvarAnalise(@PathVariable Long id, @RequestParam String analiseTexto, @RequestParam int nota) {
        Analise analise = new Analise();
        analise.setTexto(analiseTexto);
        analise.setNota(nota);
        analiseService.salvarAnalise(analise);
        return "redirect:/livros/" + id;
    }
}