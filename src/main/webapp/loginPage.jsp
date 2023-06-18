<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <style>
        body {
            background-image: url("https://i.imgur.com/xXEh9nw.png");
            background-repeat: revert;
            background-clip: border-box;
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
        }

        .login-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
            margin: auto;
            margin-top: 100px;
            max-width: 400px;
        }

    </style>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

    <title>Página de login</title>
</head>
<body>

<div class="container">

    <%@ include file="/messages.jsp" %>

    <div class="login-container">
        <h1 class="text-center mb-4">Login</h1>
        <form method="POST" action="/u/login">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email">
            </div>
            <div class="form-group">
                <label for="user">Usuario:</label>
                <input type="text" class="form-control" id="user" name="user">
            </div>
            <div class="form-group">
                <label for="senha">Senha:</label>
                <input type="password" class="form-control" id="senha" name="senha">
            </div>
            <button type="submit" class="btn btn-primary btn-block">Login</button>
        </form>
        <small class="text-muted mt-3">Não tem uma conta? Peça para um administrador do sistema realizar o cadastro.</small>
        <p class="text-muted mt-3">Login administrador ‘master’:</p>
        <p class="text-muted mt-3">E-mail: admin@admin.com</p>
        <p class="text-muted mt-3">Usuario: admin</p>
        <p class="text-muted mt-3">Senha: admin</p>
        <!--<small class="text-muted mt-3">Não tem uma conta? <a href="">Crie uma agora</a>.</small><br>-->
    </div>
</div>

<script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</script>


</body>
</html>
