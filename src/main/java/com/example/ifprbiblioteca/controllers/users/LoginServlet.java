package com.example.ifprbiblioteca.controllers.users;

import com.example.ifprbiblioteca.service.LoginService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/u/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/biblioteca");
        } else {
            request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String user = request.getParameter("user");
        String senha = request.getParameter("senha");

        LoginService loginService = new LoginService();

        try{
            loginService.validateLogin(email, user, senha, request);
        } catch (Exception e) {
            String mensagem = "Erro no login: " + e.getMessage();
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
        }

        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/biblioteca");
        }
    }
}
