<%-- 
    Document   : index
    Created on : 20/10/2019, 17:07:10
    Author     : luish
--%>

<%@page import="Entidades.Moderador"%>
<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%!
        private HttpSession s = null;
        private Usuario usr = null;
    %>
    <%
        s = request.getSession(false);
        if (s != null)
        {
            usr = (Usuario) s.getAttribute("user");
        }
        //usr = new Usuario("luis@yahoo", "123456");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta charset='utf-8'>
        <!---->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Web Piadas</title>
        <link rel="shortcut icon" href="images/favicon.ico" />
    </head>
    <body onload="atualizaGridPiadas()"> 

        <!--Navbar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <img src="images/logo2.gif" id="logoSite"/>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Inicio <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="sobre.jsp">Sobre <span class="sr-only"></span></a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" onsubmit="evtLogar_Deslogar">
                    <% if (usr != null)
                        {%>
                    <div class="dropdown mr-1">
                        <button type="button" class="btn btn-light dropdown-toggle" id="dropdownMenuOffset" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-offset="10,20">
                            <%= usr.getUser().split("@")[0]%>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                            <a class="dropdown-item" href="./deslogar?url=index.jsp">Deslogar</a>
                            <%if (usr instanceof Moderador){%>
                                    <a class="dropdown-item" href="./genUser.jsp">Cadastrar Usuário</a>
                            <%}%>
                            <a class="dropdown-item" href="./genPiadas.jsp">Gerenciar Piadas</a>
                        </div>
                    </div>
                    <% } else
                    {%>
                    <a class="btn btn-light" href="login.jsp" >Logar</a>
                    <%}%>
                    &nbsp;&nbsp;
                </form>
                <form class="form-inline my-2 my-lg-0" id="formBusca" onsubmit="return evtBusca()">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" name="busca">
                    <button class="btn btn-outline-success my-2 my-sm-0" onclick="evtBusca()">Search</button>
                </form>

            </div>
        </nav>
        <!--/.Navbar -->
        <br>
        <div id="containerPiadas" class="container overflow-auto">

        </div>
        <br><br><br><br>
        <div class="navbar fixed-bottom ver_mais">

            <button type="button" class="btn btn-default"><a href="piadas.jsp">Ver todas as piadas</a></button>
        </div>



        <!--<script src="js/bootstrap.min.js" type="text/javascript"></script>-->
        <script src="js/jquery-3.4.1.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/myScripts.js" type="text/javascript"></script>
        <script src="js/gen_reactions.js" type="text/javascript"></script>
    </body>
</html>
