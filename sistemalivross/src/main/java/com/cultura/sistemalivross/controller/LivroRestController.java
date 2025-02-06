package com.cultura.sistemalivross.controller;

import com.cultura.sistemalivross.model.Livro;
import com.cultura.sistemalivross.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroRestController {

    @Autowired // Injeção do LivroService
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    @PostMapping
    public Livro criarLivro(@RequestBody Livro filme) {
        return livroService.salvarLivro(filme);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable Long id) {
        return livroService.buscarLivroPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        return livroService.buscarLivroPorId(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setSinopse(livroAtualizado.getSinopse());
            livro.setGenero(livroAtualizado.getGenero());
            livro.setAnoLancamento(livroAtualizado.getAnoLancamento());
            return ResponseEntity.ok(livroService.salvarLivro(livro));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLivro(@PathVariable Long id) {
        if (livroService.buscarLivroPorId(id).isPresent()) {
            livroService.excluirLivro(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}