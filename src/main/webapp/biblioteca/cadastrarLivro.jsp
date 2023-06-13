<%@ page import="com.example.ifprbiblioteca.repositories.LivroRepository" %>
<%@ page import="com.example.ifprbiblioteca.models.Livro" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.ifprbiblioteca.models.Usuario" %>
<%@ page import="com.example.ifprbiblioteca.models.Autor" %>
<%@ page import="com.example.ifprbiblioteca.models.StatusLivro" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <title>Cadastro de Livros</title>
</head>
<body>

<%
    List<Autor> autores = (List<Autor>) request.getAttribute("autores");
    Usuario user = (Usuario) request.getSession().getAttribute("user");

    List<StatusLivro> statusLivros = (List<StatusLivro>) request.getAttribute("statusLivros");

%>


<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#">
                <img src="caminho/do/logo.png" alt="Logo">
            </a>
            <div class="navbar-collapse justify-content-end">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <i class="fas fa-sign-out-alt"></i> Sair
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <i class="fas fa-cog"></i> Configuração da conta
                        </a>
                    </li>
                    <% if (user.getEmail().equals("admin@admin.com")) { %>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <i class="fas fa-user-plus"></i> Cadastrar Usuário
                        </a>
                    </li>
                    <% } %>
                </ul>
            </div>
        </div>
    </nav>

    <br>

    <h1><%= "Novo livro." %></h1>

    <br>

    <div class="border rounded p-4">
        <h4 class="mb-3"></h4>
        <form action="/biblioteca/cadastrar-livro" method="POST">
            <div class="form-group">
                <label for="livroNome">Nome do livro:</label>
                <input type="text" class="form-control" name="livroNome" id="livroNome" placeholder="Nome do livro">
            </div>
            <br>
            <div class="form-group">
                <label for="Autor">Autor</label>
                <select class="custom-select" name="Autor" id="Autor">
                    <% for (Autor autor : autores) { %>
                        <option><%= autor.getNome() %></option>
                    <%}%>
                </select>
            </div>
            <br>
            <div class="form-group">
                <label for="status">Status</label>
                <select class="custom-select" name="status" id="status">
                    <% for (StatusLivro statusLivro : statusLivros) { %>
                    <option value="<%= statusLivro %>"><%= statusLivro %></option>
                    <% } %>
                </select>
            </div>

            <button type="submit" class="btn btn-success">Salvar</button>

        </form>
    </div>



</div>





<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>