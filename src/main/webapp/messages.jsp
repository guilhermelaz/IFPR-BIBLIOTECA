<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<% if (request.getAttribute("mensagem") != null) { %>
<div id="myModal" class="modal fade d-none" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="myModalLabel">Mensagem</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <%= request.getAttribute("mensagem") %>
      </div>
    </div>
  </div>
</div>

<script>
  $(document).ready(function() {
    $('#myModal').modal('show');
  });
</script>
<% } %>
