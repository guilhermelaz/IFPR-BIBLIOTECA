package com.example.ifprbiblioteca.controllers.users;

import com.example.ifprbiblioteca.models.Usuario;
import com.example.ifprbiblioteca.repositories.UsuarioRepository;
import com.example.ifprbiblioteca.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletEditarUsuario", value = "/u/editar-usuario")
public class ServletEditarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");

            UsuarioRepository usuarioRepository = new UsuarioRepository();
            Usuario usuarioSelecionado = usuarioRepository.findById(Integer.parseInt(id));

            request.setAttribute("usuarioSelecionado", usuarioSelecionado);

            request.getRequestDispatcher("/usuarios/editar-usuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String tipo = request.getParameter("tipo");
            String senha = request.getParameter("senha");
            String senhaNova = request.getParameter("novaSenha");
            String senhaNovaConfirmacao = request.getParameter("confirmarNovaSenha");

            UserService userService = new UserService();


            try {
                userService.edit_user(id, nome, email, tipo, senha, senhaNova, senhaNovaConfirmacao, request);
                response.sendRedirect("/u/usuarios");
            } catch (Exception e) {
                String mensagem = "Erro ao editar usuário: " + e.getMessage();
                request.setAttribute("mensagem", mensagem);

                UsuarioRepository usuarioRepository = new UsuarioRepository();
                Usuario usuarioSelecionado = usuarioRepository.findById(Integer.parseInt(id));
                request.setAttribute("usuarioSelecionado", usuarioSelecionado);

                request.getRequestDispatcher("/usuarios/editar-usuario.jsp").forward(request, response);
            }


        }
}
