package com.cultura.sistemalivross.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String sinopse;
    private String genero;
    private int anoLancamento;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Analise> analises; // Lista de análises associadas ao livro
}