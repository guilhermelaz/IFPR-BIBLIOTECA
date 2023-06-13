package com.example.ifprbiblioteca.controllers;

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

@WebServlet(name = "ServletEditarLivro", value = "/biblioteca/editar")
public class ServletEditarLivro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {

            String id = request.getParameter("id");

            LivroRepository livroRepository = new LivroRepository();
            Livro livroSelecionado = livroRepository.findById(Integer.parseInt(id));

            request.setAttribute("livroSelecionado", livroSelecionado);

            // Coisas do select
            AutorRepository autorRepository = new AutorRepository();
            List<Autor> autores = autorRepository.findAll();
            request.setAttribute("autores", autores);
            List<StatusLivro> statusLivros = Arrays.asList(StatusLivro.values());
            request.setAttribute("statusLivros", statusLivros);
            // // //

            request.getRequestDispatcher("editarLivro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
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
}
