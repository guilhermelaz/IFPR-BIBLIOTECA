package com.example.ifprbiblioteca.controllers;

import com.example.ifprbiblioteca.models.Usuario;
import com.example.ifprbiblioteca.repositories.UsuarioRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletEditarUsuario", value = "/biblioteca/editar-usuario")
public class ServletEditarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {

            UsuarioRepository usuarioRepository = new UsuarioRepository();

            String id = request.getParameter("id");

            Usuario usuarioSelecionado = usuarioRepository.findById(Integer.parseInt(id));

            request.setAttribute("usuarioSelecionado", usuarioSelecionado);

            request.getRequestDispatcher("editarUsuario.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuarioRepository usuarioRepository = new UsuarioRepository();

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String senhaNova = request.getParameter("novaSenha");
        String senhaNovaConfirmacao = request.getParameter("confirmarNovaSenha");


        String tipo = request.getParameter("tipo");

        Usuario usuario = usuarioRepository.findById(Integer.parseInt(id));

        usuario.setNome(nome);
        usuario.setEmail(email);


        if(senha == usuario.getSenha()){

        }
        usuario.setSenha(senha);



        usuario.setTipo(tipo);



        usuarioRepository.update(usuario);

        response.sendRedirect("/biblioteca/usuarios");


    }
}
