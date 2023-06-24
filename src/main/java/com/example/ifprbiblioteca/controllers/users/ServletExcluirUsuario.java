package com.example.ifprbiblioteca.controllers.users;

import com.example.ifprbiblioteca.repositories.LivroRepository;
import com.example.ifprbiblioteca.repositories.UsuarioRepository;
import com.example.ifprbiblioteca.service.UserService;
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

            try {
                UserService userService = new UserService();

                userService.delete_user(id, request.getSession());

                request.setAttribute("mensagem", "Usuário excluído com sucesso.");
                request.getRequestDispatcher("/u/usuarios").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("mensagem", "Erro ao excluir o usuário: " + e.getMessage());
                request.getRequestDispatcher("/u/usuarios").forward(request, response);
            }
        }
}
