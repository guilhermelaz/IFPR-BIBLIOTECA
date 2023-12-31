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

@WebServlet(name = "ServletEditarLivro", value = "/biblioteca/editar-livro")
public class ServletEditarLivro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");

            LivroRepository livroRepository = new LivroRepository();
            AutorRepository autorRepository = new AutorRepository();

            Livro livroSelecionado = livroRepository.findById(Integer.parseInt(id));

            request.setAttribute("livroSelecionado", livroSelecionado);

            List<Autor> autores = autorRepository.findAll();
            List<StatusLivro> statusLivros = Arrays.asList(StatusLivro.values());

            request.setAttribute("statusLivros", statusLivros);
            request.setAttribute("autores", autores);

            request.getRequestDispatcher("editar-livro.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String nome = request.getParameter("livroNome");
            String autorNome = request.getParameter("Autor");

            LivroRepository livroRepository = new LivroRepository();
            AutorRepository autorRepository = new AutorRepository();

            Autor autorSelecionado = autorRepository.findByName(autorNome);

            String statusSelecionado = request.getParameter("status");
            StatusLivro status = StatusLivro.valueOf(statusSelecionado);

            Livro livroEdicao = livroRepository.findById(Integer.parseInt(request.getParameter("id")));

            livroEdicao.setNome(nome);
            livroEdicao.setAutor(autorSelecionado);
            livroEdicao.setStatus(status);

            livroRepository.update(livroEdicao);

            response.sendRedirect("/biblioteca");
        }
}
