<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <title>Página de login</title>
</head>
<body>

<div class="container">
    <div class="login-container">
        <h1 class="text-center mb-4">Login</h1>
        <form method="POST" action="login">
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
        <!--<small class="text-muted mt-3">Não tem uma conta? <a href="">Crie uma agora</a>.</small><br>-->
    </div>
</div>

</body>
</html>
