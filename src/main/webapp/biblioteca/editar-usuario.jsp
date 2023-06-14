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

    <title>Novo usuário</title>
</head>
<body>

<%
    Usuario user = (Usuario) request.getSession().getAttribute("user");
    Usuario usuarioSelecionado = (Usuario) request.getAttribute("usuarioSelecionado");
%>


<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="/biblioteca">
                <img src="" alt="Logo">
            </a>
            <div class="navbar-collapse justify-content-end">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">
                            <i class="fas fa-sign-out-alt"></i> Sair
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/u/conta">
                            <i class="fas fa-cog"></i> Configuração da conta
                        </a>
                    </li>
                    <% if (user.getTipo().equals("ADMINISTRADOR")) { %>
                    <li class="nav-item">
                        <a class="nav-link" href="/biblioteca/novo-usuario">
                            <i class="fas fa-user-plus"></i> Usuários
                        </a>
                    </li>
                    <% } %>
                </ul>
            </div>
        </div>
    </nav>

    <br>

    <h1><%= "Usuarios" %></h1>

    <br>

    <div class="border rounded p-4">
        <h4 class="mb-3"></h4>
        <form action="/biblioteca/editar-usuario" method="POST">

            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" name="nome" id="nome" value="<%usuarioSelecionado.getNome()%>">
            </div>
            <br>

            <div class="form-group">
                <label for="nome">Email:</label>
                <input type="email" class="form-control" name="email" id="email" value="<%usuarioSelecionado.getEmail()%>">
            </div>
            <br>


            <div class="form-group">
                <label for="nome">Senha atual:</label>
                <input type="password" class="form-control" name="senha" id="senha">
            </div>

            <div class="form-group">
                <label for="nome">Nova senha:</label>
                <input type="password" class="form-control" name="novaSenha" id="novaSenha">
            </div>

            <div class="form-group">
                <label for="nome">Confirmar nova senha:</label>
                <input type="password" class="form-control" name="confirmarNovaSenha" id="confirmarNovaSenha">
            </div>

            <% if(user.getTipo().equals("ADMINISTRADOR")){%>
                <div>
                    <label for="tipo">Tipo:</label>
                    <select name="tipo" id="tipo">
                        <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                        <option selected value="USUARIO">Leitor</option>
                    </select>
                </div>
            <%}%>


            <br>

            <button type="submit" class="btn btn-success">Cadastrar</button>

        </form>
        <br>
    </div>



</div>





<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>