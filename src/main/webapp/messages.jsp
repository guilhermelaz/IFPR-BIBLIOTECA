<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
  String mensagem = (String) request.getAttribute("mensagem");
%>

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