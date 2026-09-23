package com.example.demo.model;

public class Usuario {
    private static Long id;
    private static String nome;
    private static String email;
    private static String cargo;

    public Usuario(Long id, String nome, String email, String cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        System.out.println("Criando novo usuário: " + this.nome);
    }

    public static Long getId() {return id;}

    public static String getNome() {return nome;}

    public static String getEmail() {return email;}

    public static String getCargo() {return cargo;}
}
