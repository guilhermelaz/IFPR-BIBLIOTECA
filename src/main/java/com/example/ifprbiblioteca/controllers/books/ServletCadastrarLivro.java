package com.example.ifprbiblioteca.controllers.books;

import com.example.ifprbiblioteca.models.Autor;
import com.example.ifprbiblioteca.models.Livro;
import com.example.ifprbiblioteca.models.StatusLivro;
import com.example.ifprbiblioteca.repositories.AutorRepository;
import com.example.ifprbiblioteca.repositories.LivroRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ServletCadastrarLivro", value = "/biblioteca/cadastrar-livro")
public class ServletCadastrarLivro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            AutorRepository autorRepository = new AutorRepository();
            List<Autor> autores = autorRepository.findAll();
            List<StatusLivro> statusLivros = Arrays.asList(StatusLivro.values());

            request.setAttribute("statusLivros", statusLivros);
            request.setAttribute("autores", autores);

            request.getRequestDispatcher("/biblioteca/cadastrar-livro.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            LivroRepository livroRepository = new LivroRepository();
            AutorRepository autorRepository = new AutorRepository();

            String nome = request.getParameter("livroNome");
            String autorNome = request.getParameter("Autor");
            String statusSelecionado = request.getParameter("status");

            Autor autorSelecionado = autorRepository.findByName(autorNome);
            StatusLivro status = StatusLivro.valueOf(statusSelecionado);

            Livro novoLivro = new Livro();
            novoLivro.setNome(nome);
            novoLivro.setAutor(autorSelecionado);
            novoLivro.setStatus(status);
            novoLivro.setDataDeCriacao(LocalDate.now());

            livroRepository.create(novoLivro);

            response.sendRedirect("/biblioteca");
        }
}

