<%-- 
    Document   : index
    Created on : 20/10/2019, 17:07:10
    Author     : luish
--%>

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
        <!---->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Web Piadas</title>
        <link rel="shortcut icon" href="images/favicon.ico" />
    </head>
    <body>

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
                    <!--
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                    -->
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
        <!--/.Navbar -->
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="noticia_wrapper">
                        <span class="noticia_autor"><%= "A1"%></span>
                        <a href="noticia?id_noticia=<%= 1%>" class="noticia_titulo"><%= "t1"/*titulo*/%></a>
                        <span class="noticia_data"><%= "dt1"/*data_noticia*/%></span>
                        <br />
                        <p class="noticia_resumo">
                            <%= "resumo1"/*resumo*/%>
                        </p>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="noticia_wrapper">
                        <span class="noticia_autor"><%= "A2"%></span>
                        <a href="noticia?id_noticia=<%= 1%>" class="noticia_titulo"><%= "t2"/*titulo*/%></a>
                        <span class="noticia_data"><%= "dt2"/*data_noticia*/%></span>

                        <br />
                        <p class="noticia_resumo">
                            <%= "resumo2"/*resumo*/%>
                        </p>
                    </div>
                </div>
            </div>

            <div class="row">
                <% for (Integer i = 2; i < 15; i++)
                    {%>
                <div class="col-md-4">
                    <div class="noticia_wrapper">
                        <span class="noticia_autor"><%= i.toString() + " Luísh"%></span>
                        <a href="noticia?id_noticia=<%= 0/*id_noticia*/%>" class="noticia_titulo"><%= i.toString() + " Notícia"/*titulo*/%></a>
                        <span class="noticia_data"><%= "Data"/*data_criacao*/%></span>
                        <br />
                        <p class="noticia_resumo">
                            <%= "Resumo"/*resumo*/%>
                        </p>
                    </div>
                </div>
                <% }%>
            </div>

            <div class="row ver_mais">
                <button type="button" class="btn btn-default"><a href="noticias">Ver todas as notícias</a></button>
            </div>

        </div>


        <!--<script src="js/bootstrap.min.js" type="text/javascript"></script>-->

        <script src="js/jquery-3.3.1.slim.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/myScripts.js" type="text/javascript"></script>
    </body>
</html>
