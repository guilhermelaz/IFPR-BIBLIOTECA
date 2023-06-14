package com.example.ifprbiblioteca.controllers;

import com.example.ifprbiblioteca.models.Usuario;
import com.example.ifprbiblioteca.repositories.UsuarioRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletNovoUsuario", value = "/biblioteca/novo-usuario")
public class ServletNovoUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            UsuarioRepository usuarioRepository = new UsuarioRepository();

            List<Usuario> usuarios = usuarioRepository.findAll();

            request.setAttribute("usuarios", usuarios);

            request.getRequestDispatcher("novo-usuario.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuarioRepository usuarioRepository = new UsuarioRepository();

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String tipo = request.getParameter("tipo");

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);
        novoUsuario.setTipo(tipo);

        usuarioRepository.create(novoUsuario);

        response.sendRedirect("/biblioteca");
    }
}
