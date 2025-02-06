package com.cultura.sistemalivross.service;

import com.cultura.sistemalivross.model.Analise;
import com.cultura.sistemalivross.repository.AnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseService {

    @Autowired // Injeção do AnaliseRepository
    private AnaliseRepository analiseRepository;

    public Analise salvarAnalise(Analise analise) {
        return analiseRepository.save(analise);
    }

    public List<Analise> listarAnalisesPorLivro(Long livroId) {
        return analiseRepository.findByLivroId(livroId);
    }

    public void excluirAnalise(Long id) {
        analiseRepository.deleteById(id);
    }

    public Analise atualizarAnalise(Analise analise) {
        return analiseRepository.save(analise);
    }
}