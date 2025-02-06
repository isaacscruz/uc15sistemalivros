package com.cultura.sistemalivross.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Analise")
public class Analise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String texto;
    private int nota;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;
}