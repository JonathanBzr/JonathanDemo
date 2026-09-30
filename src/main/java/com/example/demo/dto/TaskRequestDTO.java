package com.example.demo.dto;

import java.time.LocalDate;
public record TaskRequestDTO(
        String titulo,
        boolean concluida,
        String prioridade
) {}