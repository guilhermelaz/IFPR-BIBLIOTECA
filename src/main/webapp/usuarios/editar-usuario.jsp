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
    Usuario usuarioSelecionado = (Usuario) request.getAttribute("usuarioSelecionado");
%>


<div class="container">

    <%@include file="../navbar.jsp"%>
    <br>

    <h1><%= "Usuarios" %></h1>

    <br>

    <div class="border rounded p-4">
        <h4 class="mb-3"></h4>
        <form action="/u/editar-usuario" method="POST">
            <input type="hidden" name="id" value="<%= usuarioSelecionado.getId() %>">

            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" name="nome" id="nome" value="<%= usuarioSelecionado.getNome() %>">
            </div>
            <br>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" name="email" id="email" value="<%= usuarioSelecionado.getEmail() %>">
            </div>
            <br>

            <div class="form-group">
                <label for="senha">Senha atual:</label>
                <input type="password" class="form-control" name="senha" id="senha">
            </div>

            <div class="form-group">
                <label for="novaSenha">Nova senha:</label>
                <input type="password" class="form-control" name="novaSenha" id="novaSenha">
            </div>

            <div class="form-group">
                <label for="confirmarNovaSenha">Confirmar nova senha:</label>
                <input type="password" class="form-control" name="confirmarNovaSenha" id="confirmarNovaSenha">
            </div>

            <% if(currentUser.getTipo().equals("ADMINISTRADOR")){ %>
            <br>
            <div>
                <label for="tipo">Tipo:</label>
                <select name="tipo" id="tipo">
                    <option selected value="USUARIO">Leitor</option>
                    <option value="ADMINISTRADOR">Administrador</option>
                </select>
            </div>
            <% } %>

            <br>

            <button type="submit" class="btn btn-success">Salvar</button>
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