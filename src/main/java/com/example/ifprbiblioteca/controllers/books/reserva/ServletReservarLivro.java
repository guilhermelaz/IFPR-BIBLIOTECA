package com.example.ifprbiblioteca.controllers.books.reserva;

import com.example.ifprbiblioteca.models.Livro;
import com.example.ifprbiblioteca.models.StatusLivro;
import com.example.ifprbiblioteca.models.Usuario;
import com.example.ifprbiblioteca.repositories.LivroRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletReservarLivro", value = "/biblioteca/reservar-livro")
public class ServletReservarLivro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String id = request.getParameter("id");

            LivroRepository livroRepository = new LivroRepository();

            // Achando o livro
            Livro livroReservar = livroRepository.findById(Integer.parseInt(id));
            livroReservar.setStatus(StatusLivro.EMPRESTADO);

            // Setando o livro no U atual
            Usuario usuario = (Usuario) request.getSession().getAttribute("user");
            livroReservar.setUsuario(usuario);
            usuario.setLivroEmprestado(livroReservar);


            livroRepository.update(livroReservar);

            response.sendRedirect("/biblioteca");
        }
}
