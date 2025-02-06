package com.cultura.sistemalivross.repository;

import com.cultura.sistemalivross.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface LivroRepository extends JpaRepository<Livro, Long> {
}