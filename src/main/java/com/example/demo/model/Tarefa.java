package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tarefas")
@Getter
@Setter
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String titulo;
    private boolean concluida;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    public Tarefa(Long id, String titulo, boolean b, Prioridade baixa) {
        this.id = id;
        this.titulo = titulo;
        this.concluida = false;
        this.prioridade= Prioridade.BAIXA;
        System.out.println("Criando Tarefa..."); }

