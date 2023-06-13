<%@ page import="com.example.ifprbiblioteca.repositories.LivroRepository" %>
<%@ page import="com.example.ifprbiblioteca.models.Livro" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.ifprbiblioteca.models.Usuario" %>
<%@ page import="com.example.ifprbiblioteca.models.Autor" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

  <title>Biblioteca IFPR</title>
</head>
<body>

<%
    List<Livro> livros = (List<Livro>) request.getAttribute("livros");
    List<Autor> autores = (List<Autor>) request.getAttribute("autores");
    Usuario user = (Usuario) request.getSession().getAttribute("user");

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

<h1><%= "Biblioteca." %></h1>
<br/>

<!--Tabela -->
  <div class="table-toolbar">
    <a class="btn btn-primary" href="/biblioteca/cadastrar-livro">
      <i class="fas fa-plus"></i> Adicionar livro
    </a>
    <!--<button class="btn btn-success" data-modal-target="modalAutor">
      <i class="fas fa-plus"></i> Cadastrar Autor
    </button>-->
  </div>

<br>

<table class="table table-bordered rounded">
  <thead class="thead-dark">
  <tr>
    <th>Id</th>
    <th>Nome</th>
    <th>Data de criação</th>
    <th>Autor</th>
    <th>Status</th>
    <th>Ações</th>
  </tr>
  </thead>
  <tbody>
  <% for (Livro livro : livros) { %>
  <tr>
    <td><%= livro.getId() %></td>
    <td><%= livro.getNome() %></td>
    <td><%= livro.getDataDeCriacao() %></td>
    <td><%= livro.getAutor().getNome() %></td>
    <td><%= livro.getStatus() %></td>
    <td>
      <a href="/biblioteca/excluir/<%= livro.getId()%>" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i> Deletar</a>
      <button onclick="" class="btn btn-info btn-sm"><i class="fas fa-pencil-alt"></i> Editar</button>
      <button onclick="" class="btn btn-success btn-sm"><i class="fas fa-book"></i> Status</button>

    </td>
  </tr>
  <% } %>
  </tbody>
</table>

</div>





<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>