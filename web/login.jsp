<%-- 
    Document   : login
    Created on : 20/10/2019, 20:09:15
    Author     : luish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/signin.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body class="text-center">

        <form class="form-signin" action="validaUsuario" name="flogin" method="POST" id="flogin" enctype="multipart/form-data">
            <div id="alerta">
                <%
                    String temp = request.getParameter("erro");
                    if (temp != null)
                    {%>
                        <%= temp%>
                <% }%>
            </div>
            <!--<img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">-->
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>


            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="text" id="inputEmail" class="form-control" placeholder="Email/Usuário" name="usr" required autofocus>


            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Senha" name="pass" required>


            <input  type="submit" class="btn btn-lg btn-primary btn-block" name="valid" value="Sign in"/>


            <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
        </form>

        <!---->
        <script src="js/jquery-3.3.1.slim.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>

        <!--
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        -->
        <script src="js/myScripts.js" type="text/javascript"></script>
    </body>
</html>
