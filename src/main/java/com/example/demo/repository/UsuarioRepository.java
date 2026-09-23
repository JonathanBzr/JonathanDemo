package com.example.demo.repository;

import com.example.demo.model.Usuario;

import java.util.*;

public class UsuarioRepository {

    private final Map<Long, Usuario> banco = new LinkedHashMap<Long, Usuario>();

    public static void delete(Usuario usuario) {
    }

    public Usuario salvar(Usuario usuario) {
        System.out.println("[REPOSITORY] Salvando usuario: " + Usuario.getNome());
        banco.put(Usuario.getId(), usuario);
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        System.out.println("[REPOSITORY] Listando todos os usuarios do sistema...");
        return new ArrayList<Usuario>(banco.values());
    }

    public Usuario buscarPorId(Long id) {
        System.out.println("[REPOSITORY] Buscando usuario: " + id);
        return banco.get(id);
    }

}
