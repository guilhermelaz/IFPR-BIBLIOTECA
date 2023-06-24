package com.example.ifprbiblioteca.controllers.users;

import com.example.ifprbiblioteca.models.Usuario;
import com.example.ifprbiblioteca.repositories.UsuarioRepository;
import com.example.ifprbiblioteca.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "ServletNovoUsuario", value = "/u/usuarios")
public class ServletUsuarios extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            UsuarioRepository usuarioRepository = new UsuarioRepository();
            List<Usuario> usuarios = usuarioRepository.findAll();

            request.setAttribute("usuarios", usuarios);

            String mensagem = (String) request.getAttribute("mensagem");
            request.setAttribute("mensagem", mensagem);

            request.getRequestDispatcher("/usuarios/usuarios.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String tipo = request.getParameter("tipo");

        try{
            userService.create_user(nome, email, senha, tipo);
            response.sendRedirect("/u/usuarios");
        } catch (Exception e) {
            String mensagem = "Erro ao criar o usuário: " + e.getMessage();
            response.sendRedirect("/u/usuarios?mensagem=" + URLEncoder.encode(mensagem, StandardCharsets.UTF_8));
        }
    }
}
