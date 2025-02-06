package com.cultura.sistemalivross.controller;

import com.cultura.sistemalivross.model.Livro;
import com.cultura.sistemalivross.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService; // Nome da variável: livroService

    @GetMapping("/livros")
    public String listarLivros(Model model) {
        List<Livro> livros = livroService.listarLivros();
        model.addAttribute("livros", livros);
        return "livros";
    }

    @GetMapping("/livros/cadastrar")
    public String cadastrarLivro() {
        return "cadastroLivro";
    }

    @PostMapping("/livros/cadastrar")
    public String salvarLivro(Livro livro) {
        livroService.salvarLivro(livro);
        return "redirect:/livros";
    }

    @GetMapping("/livros/detalhes/{id}")
    public String detalhesLivro(@PathVariable Long id, Model model) {
        Livro livro = livroService.buscarLivroPorId(id).orElse(null);
        if (livro != null) {
            model.addAttribute("livro", livro);
        }
        return "detalhesLivro";
    }
}