package com.example.ifprbiblioteca.service;

import com.example.ifprbiblioteca.models.Usuario;
import com.example.ifprbiblioteca.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {
    public void validateLogin(String email, String user, String password, HttpServletRequest request) throws Exception {

        UsuarioRepository usuarioRepository = new UsuarioRepository();

        // verificação se o email existe no banco de dados:
        Usuario usuario = usuarioRepository.findByEmail(email);
        System.out.println("Usuário encontrado: " + usuario.getEmail());

        if(usuario == null || usuario.getEmail().isEmpty()){
            System.out.println("Email inválido ou não cadastrado.");
            throw new Exception("Email inválido ou não cadastrado.");
        }

        // verificação dos parâmetros passados:
        if(email == null || email.isEmpty()){
            System.out.println("Campo email vazio.");
            throw new Exception("Email inválido");
        }

        if(user == null || user.isEmpty()){
            System.out.println("Campo usuário vazio.");
            throw new Exception("Usuário inválido");
        }

        if(password == null || password.isEmpty()){
            System.out.println("Campo senha vazio.");
            throw new Exception("Senha inválida");
        }

        // verificação final
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