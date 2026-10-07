package com.example.demo.repository;

import com.example.demo.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}
