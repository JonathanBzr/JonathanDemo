package com.example.demo.service;

import com.example.demo.dto.UsuarioResponseDTO;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.example.demo.model.Usuario.getCargo;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final AtomicLong sequencia = new AtomicLong();

    public UsuarioService(UsuarioRepository usuarioRepository) {this.usuarioRepository = usuarioRepository;}

    public Usuario buscarPorId(Long id) {
        System.out.println("[SERVICE] Buscando usuario: " + id);
        return usuarioRepository.buscarPorId(id);
    }

    public List<Usuario> buscarTodos() {
        System.out.println("[SERVICE] Buscando todos usuarios");
        return usuarioRepository.listarUsuarios();
    }

    public Usuario deletarPorId(Long id) {
        System.out.println("[SERVICE] Deletando usuario: " + id);
        Usuario usuario = usuarioRepository.buscarPorId(id);
        UsuarioRepository.delete(usuario);
        return usuario;
    }

    public UsuarioResponseDTO criar(UsuarioResponseDTO dto) {
        String nome = dto.nome();
        String email = dto.email();
        String cargo = dto.cargo();
        Usuario usuario = new Usuario(sequencia.incrementAndGet(), dto.nome(), dto.email(), dto.cargo());
        System.out.println("[SERVICE] Criando usuario: " + usuario);
        if (nome == null || email == null || cargo == null) {
            throw new IllegalArgumentException("Nome, email e cargo não podem ser vazio! Favor inserir o dado faltante");
        }
        Usuario salva= usuarioRepository.salvar(salva);
        return toResponseDTO(salva);
    }

    private UsuarioResponseDTO toResponseDTO(Usuario salva) {
        return new UsuarioResponseDTO(
                Usuario.getId(),
                Usuario.getNome(),
                Usuario.getEmail(),
                Usuario.getCargo()
        );
    }

}

