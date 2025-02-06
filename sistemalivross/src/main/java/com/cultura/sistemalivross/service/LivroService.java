package com.cultura.sistemalivross.service;

import com.cultura.sistemalivross.model.Livro;
import com.cultura.sistemalivross.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class LivroService {

    @Autowired 
    private LivroRepository livroRepository;

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarLivroPorId(Long id) {
        return livroRepository.findById(id);
    }

    public void excluirLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public Livro atualizarLivro(Livro livro) {
        return livroRepository.save(livro);
    }
}