package com.cultura.sistemalivross.repository;

import com.cultura.sistemalivross.model.Analise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Long> {
    List<Analise> findByLivroId(Long livroId); // Método para buscar análises por ID do livro
}