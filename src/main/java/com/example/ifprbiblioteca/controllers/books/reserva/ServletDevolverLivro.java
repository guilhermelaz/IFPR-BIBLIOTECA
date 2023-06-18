package com.example.ifprbiblioteca.controllers.books.reserva;

import com.example.ifprbiblioteca.models.Livro;
import com.example.ifprbiblioteca.models.StatusLivro;
import com.example.ifprbiblioteca.repositories.LivroRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletDevolverLivro", value = "/biblioteca/devolver-livro")
public class ServletDevolverLivro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/u/login");
        } else {
            String id = request.getParameter("id");
            LivroRepository livroRepository = new LivroRepository();

            Livro livroDevolver = livroRepository.findById(Integer.parseInt(id));
            livroDevolver.setStatus(StatusLivro.DISPONIVEL);
            livroDevolver.setUsuario(null);

            livroRepository.update(livroDevolver);

            response.sendRedirect("/biblioteca");
        }
    }
}
