package com.example.demo.controller;

import com.example.demo.dto.UsuarioResponseDTO;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;}
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody UsuarioResponseDTO usuario){
        UsuarioResponseDTO criado= usuarioService.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }
    @GetMapping
    public ResponseEntity<UsuarioService> buscarTodos(){
        System.out.println("[CONTROLLER] listar Requisição: GET /usuarios");
        return ResponseEntity.ok((UsuarioService) usuarioService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        System.out.println("[CONTROLLER] Requisição recebida: GET /usuarios/" + id);
        return ResponseEntity.ok((Usuario) usuarioService.buscarPorId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> deletarUsuarioPorId(@PathVariable Long id){
        System.out.println("[CONTROLLER] Requisição recebida: DELETE /usuarios/" + id);
        usuarioService.deletarPorId();
        return ResponseEntity.noContent().build();
    }
}
