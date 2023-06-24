package com.example.ifprbiblioteca.controllers.books;

import com.example.ifprbiblioteca.models.Autor;
import com.example.ifprbiblioteca.models.Livro;
import com.example.ifprbiblioteca.repositories.AutorRepository;
import com.example.ifprbiblioteca.repositories.LivroRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BibliotecaServlet", value = "/biblioteca")
public class ServletBiblioteca extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            LivroRepository livroRepository = new LivroRepository();
            List<Livro> livros = livroRepository.findAll();

            AutorRepository autorRepository = new AutorRepository();
            List<Autor> autores = autorRepository.findAll();

            request.setAttribute("livros", livros);
            request.setAttribute("autores", autores);

            request.getRequestDispatcher("/biblioteca/biblioteca.jsp").forward(request, response);
        }
}
