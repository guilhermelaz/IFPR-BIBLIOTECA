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

  <title>Biblioteca IFPR</title>
</head>
<body>

<%
  List<Livro> livros = (List<Livro>) request.getAttribute("livros");
  List<Autor> autores = (List<Autor>) request.getAttribute("autores");
%>

<div class="container">
<%@include file="../navbar.jsp"%>
<h1><%="Biblioteca."%></h1>
<br>

<!--Tabela -->

    <% if (isAdmin) {%>
      <div class="table-toolbar">
        <a class="btn btn-primary" href="/biblioteca/cadastrar-livro">
          <i class="fas fa-plus"></i> Adicionar livro
        </a>
      </div>
    <%}%>
    <!--<button class="btn btn-success" data-modal-target="modalAutor">
      <i class="fas fa-plus"></i> Cadastrar Autor
    </button>-->


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
    <td><%=livro.getId()%></td>
    <td><%=livro.getNome()%></td>
    <td><%=livro.getDataDeCriacao()%></td>
    <td><%=livro.getAutor().getNome()%></td>
    <td><%=livro.getStatus()%></td>
    <td>
      <% if (isAdmin){%>

      <button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#confirmDeleteModal<%= livro.getId() %>"><i class="fa fa-trash"></i> Deletar</button>
      <div class="modal fade" id="confirmDeleteModal<%= livro.getId() %>" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel<%= livro.getId() %>" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="confirmDeleteModalLabel<%= livro.getId() %>">Confirmar Exclusão</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <p>Tem certeza de que deseja excluir esse livro?</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
              <a href="/biblioteca/excluir-livro?id=<%= livro.getId() %>" class="btn btn-danger">Excluir</a>
            </div>
          </div>
        </div>
      </div>

      <!-- <a href="/biblioteca/excluir?id=<%=livro.getId()%>" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i> Deletar</a> -->

      <a href="/biblioteca/editar-livro?id=<%=livro.getId()%>" class="btn btn-info btn-sm"><i class="fas fa-pencil-alt"></i> Editar</a>
      <%}%>

      <% if (livro.getStatus().equals(StatusLivro.DISPONIVEL)){%>
      <a href="/biblioteca/reservar-livro?id=<%=livro.getId()%>" class="btn btn-success btn-sm"><i class="fas fa-book"></i> Reservar</a>
      <%} else if (livro.getStatus().equals(StatusLivro.INDISPONIVEL)){%>
      <button href="#" class="btn btn-secondary btn-sm"><i class="fas fa-book"></i> Indisponível</button>
      <%} else if (livro.getStatus().equals(StatusLivro.EMPRESTADO) && (isAdmin || (livro.getUsuario() != null && livro.getUsuario().getEmail().equals(currentUser.getEmail())))) { %>
      <a href="/biblioteca/devolver-livro?id=<%=livro.getId()%>" class="btn btn-danger btn-sm"><i class="fas fa-book"></i> Devolver</a>
      <% } %>




    </td>
  </tr>
  <% } %>
  </tbody>
</table>

</div>





<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>