package com.example.ifprbiblioteca.controllers.books;

import com.example.ifprbiblioteca.repositories.LivroRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletExcluirLivro", value = "/biblioteca/excluir-livro")
public class ServletExcluirLivro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        LivroRepository livroRepository = new LivroRepository();
        livroRepository.removeById(Integer.parseInt(id));

        response.sendRedirect("/biblioteca");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
