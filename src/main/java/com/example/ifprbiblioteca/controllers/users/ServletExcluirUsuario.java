package com.example.ifprbiblioteca.controllers.users;

import com.example.ifprbiblioteca.repositories.LivroRepository;
import com.example.ifprbiblioteca.repositories.UsuarioRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletExcluirUsuario", value = "/u/excluir-usuario")
public class ServletExcluirUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String id = request.getParameter("id");

            UsuarioRepository usuarioRepository = new UsuarioRepository();
            usuarioRepository.removeById(Integer.parseInt(id));

            response.sendRedirect("/u/usuarios");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
