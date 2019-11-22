<%-- 
    Document   : genUser
    Created on : 27/10/2019, 11:51:52
    Author     : luish
--%>

<%@page import="Entidades.Moderador"%>
<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%!
        private Usuario usr;
        private HttpSession s;
    %>
    <%
        s = request.getSession();
        if (s == null)
        {
            response.sendRedirect("./index.jsp");
        } else
        {
            usr = (Usuario) s.getAttribute("user");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="images/favicon.ico" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Gerenciar Usuário</title>
    </head>
    <body>
        <%
            if (usr == null || usr.getNivel() != 0)
                response.sendRedirect("index.jsp");
            else
            {
        %>
        <!--Navbar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <img src="images/logo2.gif" id="logoSite"/>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="sobre.jsp">Sobre <span class="sr-only"></span></a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" onsubmit="evtLogar_Deslogar">
                    <% if (usr != null && usr instanceof Moderador)
                        {%>
                    <div class="dropdown mr-1">
                        <button type="button" class="btn btn-light dropdown-toggle" id="dropdownMenuOffset" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-offset="10,20">
                            <%= usr.getUser().split("@")[0]%>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                            <a class="dropdown-item" href="./deslogar?url=index.jsp">Deslogar</a>
                            <a class="dropdown-item" href="./genUser.jsp">Cadastrar Usuário</a>
                            <a class="dropdown-item" href="./genPiadas.jsp">Gerenciar Piadas</a>
                        </div>
                    </div>
                    <% } else
                    {%>
                    <a class="btn btn-light" href="login.jsp" >Logar</a>
                    <%}%>
                    &nbsp;&nbsp;
                </form>
                <form class="form-inline my-2 my-lg-0" onsubmit="return evtBusca()">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" name="busca">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>

            </div>
        </nav>

        <div class="container conFormUser">
            <div class="col-12 mt-5" id="alerta">

            </div>
            <form onsubmit="enviaFormUsuario()" name="fusuario" id="fusuario">
                <div class="form-group row">
                    <label class="col-2">Usuário:</label> &nbsp;
                    <div class="col-10">
                        <input id="usr" name="usr" placeholder="usuário" type="text" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="pass" class="col-2">Password:</label> &nbsp;
                    <div class="col-10">
                        <input id="pass" name="pass" placeholder="Password" type="password" class="form-control">
                    </div>
                </div>
                <div class="row">
                    <label class="col-2">Nível:</label>
                </div>
                <div class="form-group row">
                    <div class="col-10">
                        <!-- Default unchecked -->
                        <div class="custom-control custom-radio">
                            <input type="radio" class="custom-control-input" id="defaultUnchecked" name="nNivel" value="0">
                            <label class="custom-control-label" for="defaultUnchecked">Moderador</label>
                        </div>

                        <!-- Default checked -->
                        <div class="custom-control custom-radio">
                            <input type="radio" class="custom-control-input" id="defaultChecked" name="nNivel" value="1" checked>
                            <label class="custom-control-label" for="defaultChecked">Normal</label>
                        </div>
                    </div>
                </div> 
                <div class="form-group row">
                    <div class="offset-4 col-8">
                        <button name="submit" type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
        </div>
        <script src="js/jquery-3.3.1.slim.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/genUsuario.js" type="text/javascript"></script>
        <% }%>
    </body>
</html>
