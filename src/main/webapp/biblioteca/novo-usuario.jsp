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
  List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
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
    <form action="/biblioteca/novo-usuario" method="POST">

      <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" class="form-control" name="nome" id="nome">
      </div>
      <br>

      <div class="form-group">
        <label for="nome">Email:</label>
        <input type="email" class="form-control" name="email" id="email">
      </div>
      <br>

      <div class="form-group">
        <label for="nome">Senha:</label>
        <input type="password" class="form-control" name="senha" id="senha">
      </div>
      <br>

      <div class="form-group">
        <label for="tipo">Tipo:</label>
        <select class="custom-select" name="tipo" id="tipo">
          <option value="ADMINISTRADOR">ADMINISTRADOR</option>
          <option selected value="USUARIO">Leitor</option>
        </select>
      </div>
      <br>

      <button type="submit" class="btn btn-success">Cadastrar</button>

    </form>

    <br>

    <table class="table table-bordered rounded">
      <thead>
      <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Ações</th>
      </tr>
      </thead>
      <tbody>
      <% if (usuarios != null && !usuarios.isEmpty()) { %>
        <% for (Usuario usuario : usuarios) { %>
        <tr>
          <td><%= usuario.getNome() %></td>
          <td><%= usuario.getEmail() %></td>
          <td>
            <a href="" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#confirmDeleteModal<%=usuario.getId()%>"><i class="fa fa-trash"></i> Deletar</a>
            <a href="/biblioteca/editar-usuario?id=<%=usuario.getId()%>" class="btn btn-info btn-sm"><i class="fas fa-pencil-alt"></i> Editar</a>
          </td>
        </tr>
      <div class="modal fade" id="confirmDeleteModal<%=usuario.getId()%>" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel<%=usuario.getId()%>" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="confirmDeleteModalLabel<%=usuario.getId()%>">Confirmar Exclusão</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <p>Tem certeza de que deseja excluir esse livro?</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
              <a href="/biblioteca/excluir-usuario?id=<%=usuario.getId()%>" class="btn btn-danger">Excluir</a>
            </div>
          </div>
        </div>
      </div>


        <%}%>
      <%}%>
      </tbody>
    </table>


  </div>



</div>





<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>