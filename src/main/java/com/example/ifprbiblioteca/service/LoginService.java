package com.example.ifprbiblioteca.service;

import com.example.ifprbiblioteca.models.Usuario;
import com.example.ifprbiblioteca.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {
    public void validateLogin(String email, String user, String password, HttpServletRequest request) throws Exception {
        UsuarioRepository usuarioRepository = new UsuarioRepository();

        try{
            usuarioRepository.findByEmail(email);
        } catch (Exception e) {
            System.out.println("Email inválido ou não cadastrado.");
            throw new Exception("Email inválido ou não cadastrado.");
        }

        Usuario usuario = usuarioRepository.findByEmail(email);

        System.out.println("Usuário encontrado: " + usuario.getEmail());

        if(email == null || email.isEmpty()){
            System.out.println("Campo email vazio.");
            throw new Exception("Campo e-mail vazio.");
        }

        if(user == null || user.isEmpty()){
            System.out.println("Campo usuário vazio.");
            throw new Exception("Campo usuário vazio.");
        }

        if(password == null || password.isEmpty()){
            System.out.println("Campo senha vazio.");
            throw new Exception("Campo senha vazio.");
        }

        if(user.equals(usuario.getNome()) && password.equals(usuario.getSenha())){
            HttpSession session = request.getSession();
            session.setAttribute("is_logged_in", true);
            session.setAttribute("user", usuario);
            System.out.println("Passou na verificação de login.");
        }
        else {
            throw new Exception("Usuário ou senha incorreto.");
        }
    }
}