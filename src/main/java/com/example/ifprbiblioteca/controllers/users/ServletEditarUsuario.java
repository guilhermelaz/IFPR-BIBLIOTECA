package com.example.ifprbiblioteca.controllers.users;

import com.example.ifprbiblioteca.models.Usuario;
import com.example.ifprbiblioteca.repositories.UsuarioRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletEditarUsuario", value = "/u/editar-usuario")
public class ServletEditarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
            String id = request.getParameter("id");

            UsuarioRepository usuarioRepository = new UsuarioRepository();
            Usuario usuarioSelecionado = usuarioRepository.findById(Integer.parseInt(id));

            request.setAttribute("usuarioSelecionado", usuarioSelecionado);

            request.getRequestDispatcher("/usuarios/editar-usuario.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String tipo = request.getParameter("tipo");
            String senha = request.getParameter("senha");
            String senhaNova = request.getParameter("novaSenha");
            String senhaNovaConfirmacao = request.getParameter("confirmarNovaSenha");

            UsuarioRepository usuarioRepository = new UsuarioRepository();

            Usuario usuarioSelecionado = usuarioRepository.findById(Integer.parseInt(id));

            usuarioSelecionado.setNome(nome);
            usuarioSelecionado.setEmail(email);
            if (senha.equals(usuarioSelecionado.getSenha()) && senhaNova.equals(senhaNovaConfirmacao)) {
                usuarioSelecionado.setSenha(senhaNova);
            }
            if (!usuarioSelecionado.getTipo().equals(tipo)) {
                Usuario uAdmCheck = (Usuario) request.getSession().getAttribute("user");
                if (uAdmCheck.getTipo().equals("ADMINISTRADOR")) {
                    usuarioSelecionado.setTipo(tipo);
                }
            }
            usuarioRepository.update(usuarioSelecionado);

            response.sendRedirect("/u/usuarios");
        }
    }
}
