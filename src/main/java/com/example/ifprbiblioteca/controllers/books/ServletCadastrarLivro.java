package com.example.ifprbiblioteca.controllers.books;

import com.example.ifprbiblioteca.models.Autor;
import com.example.ifprbiblioteca.models.Livro;
import com.example.ifprbiblioteca.models.StatusLivro;
import com.example.ifprbiblioteca.repositories.AutorRepository;
import com.example.ifprbiblioteca.repositories.LivroRepository;
import com.example.ifprbiblioteca.service.BookService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ServletCadastrarLivro", value = "/biblioteca/cadastrar-livro")
public class ServletCadastrarLivro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String mensagem = (String) request.getAttribute("mensagem");

            AutorRepository autorRepository = new AutorRepository();
            List<Autor> autores = autorRepository.findAll();
            List<StatusLivro> statusLivros = Arrays.asList(StatusLivro.values());

            request.setAttribute("statusLivros", statusLivros);
            request.setAttribute("autores", autores);

            request.getRequestDispatcher("/biblioteca/cadastrar-livro.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            BookService bookService = new BookService();

            String nome = request.getParameter("livroNome");
            String autorNome = request.getParameter("Autor");
            String statusSelecionado = request.getParameter("status");

            try {
                bookService.create_book(nome, autorNome, statusSelecionado);
                response.sendRedirect("/biblioteca");
            } catch (Exception e) {
                String mensagem = "Erro ao cadastrar livro: " + e.getMessage();
                response.sendRedirect("/biblioteca?mensagem=" + URLEncoder.encode(mensagem, StandardCharsets.UTF_8));
            }
        }
}

