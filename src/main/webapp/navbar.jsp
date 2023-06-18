<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Usuario currentUser = (Usuario) request.getSession().getAttribute("user");
    boolean isAdmin = false;
    if (currentUser.getTipo().equals("ADMINISTRADOR")) {
        isAdmin = true;
    }

    String mensagem = (String) request.getAttribute("mensagem");
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="/biblioteca">
            <img src="" alt="Inicio">
        </a>
        <div class="navbar-collapse justify-content-end">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link"><%= currentUser.getNome()%></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/u/logout"><i class="fas fa-sign-out-alt"></i> Sair</a>
                </li>

                <% if (isAdmin){%>
                <li class="nav-item">
                    <a class="nav-link" href="/u/usuarios"><i class="fas fa-cog"></i> Usuários</a>
                </li>
                <%}%>

<%--                <% if (!isAdmin){%>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="/u/editar-usuario"><i class="fas fa-cog"></i> Minha conta</a>--%>
<%--                </li>--%>
<%--                <%}%>--%>
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

<% if (mensagem != null && !mensagem.isEmpty()) { %>
<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="myModalLabel">Aviso</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <%= mensagem %>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script>
    $(document).ready(function() {
        $('#myModal').modal('show');
    });
</script>
<% } %>
