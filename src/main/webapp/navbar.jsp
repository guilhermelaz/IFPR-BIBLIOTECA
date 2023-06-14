<%@ page import="com.example.ifprbiblioteca.models.Usuario" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%  Usuario currentUser = (Usuario) request.getSession().getAttribute("user");
    boolean isAdmin = false;
    if (currentUser.getTipo().equals("ADMINISTRADOR")) {
        isAdmin = true;
    }
%>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="/biblioteca">
                <img src="" alt="Inicio">
            </a>
            <div class="navbar-collapse justify-content-end">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/u/logout"><i class="fas fa-sign-out-alt"></i> Sair</a>
                    </li>

                    <% if (isAdmin){%>
                    <li class="nav-item">
                        <a class="nav-link" href="/u/usuarios"><i class="fas fa-cog"></i> Usuários</a>
                    </li>
                    <%}%>

                    <% if (!isAdmin){%>
                    <li class="nav-item">
                        <a class="nav-link" href="/u/editar-usuario"><i class="fas fa-cog"></i> Minha conta</a>
                    </li>
                    <%}%>
                    <!--
                    <li class="nav-item">
                        <a class="nav-link" href="/biblioteca/usuarios">
                            <i class="fas fa-user-plus"></i> Usuários
                        </a>
                    </li>
                    -->
                </ul>
            </div>
        </div>
    </nav>