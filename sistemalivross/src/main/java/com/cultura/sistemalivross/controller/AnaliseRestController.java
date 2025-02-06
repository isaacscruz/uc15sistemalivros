package com.cultura.sistemalivross.controller;

import com.cultura.sistemalivross.model.Analise;
import com.cultura.sistemalivross.model.Livro;
import com.cultura.sistemalivross.repository.AnaliseRepository;
import com.cultura.sistemalivross.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analises")
public class AnaliseRestController {

    @Autowired
    private AnaliseRepository analiseRepository;

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Analise> listarAnalises() {
        return analiseRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Analise> criarAnalise(@RequestBody Analise analise) {
        Livro livro = livroRepository.findById(analise.getLivro().getId()).orElse(null);
        if (livro == null) {
            return ResponseEntity.badRequest().build();
        }
        analise.setLivro(livro);
        return ResponseEntity.ok(analiseRepository.save(analise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAnalise(@PathVariable Long id) {
        if (analiseRepository.existsById(id)) {
            analiseRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}