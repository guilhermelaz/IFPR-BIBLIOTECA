package com.example.ifprbiblioteca.controllers;

import com.example.ifprbiblioteca.models.Livro;
import com.example.ifprbiblioteca.models.StatusLivro;
import com.example.ifprbiblioteca.models.Usuario;
import com.example.ifprbiblioteca.repositories.LivroRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletReservarLivro", value = "/biblioteca/reservar")
public class ServletReservarLivro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            LivroRepository livroRepository = new LivroRepository();
            String id = request.getParameter("id");


            Livro livroReservar = livroRepository.findById(Integer.parseInt(id));

            livroReservar.setStatus(StatusLivro.EMPRESTADO);
            livroReservar.setUsuario((Usuario) request.getSession().getAttribute("user"));

            response.sendRedirect("/biblioteca");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
