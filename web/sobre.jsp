<%-- 
    Document   : sobre
    Created on : 22/11/2019, 15:01:29
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
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Temperamentos</title>
        <link rel="icon" href="imagem/icone.png">
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <!-- <link rel='stylesheet' href='css/Mystyle.css'>-->


    </head>


    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <img src="images/logo2.gif" id="logoSite"/>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
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
                <form class="form-inline my-2 my-lg-0" id="formBusca" onsubmit="return evtBusca()">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" name="busca">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>

            </div>
        </nav>
        <!--/.Navbar -->

        <main>
            <article>
                <div class="container bg-light">
                    <!-- Introduction Row -->
                    <h1 class="my-4">Sobre nós
                        <small>conheça-nos!</small>
                    </h1>
                    <p class="lead text-justify"><a href="#" target="_blank">titulo</a> Descrição</p>

                    <!-- Team Members Row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h2 class="my-4">Nosso time</h2>
                        </div>
                        <div class="col-lg-4 col-sm-6 text-center mb-4">
                            <img class="rounded-circle img-fluid d-block mx-auto" src="http://placehold.it/200x200" alt="">
                            <h3>Luís H. Picinin Jandre
                                <small>Developer</small>
                            </h3>
                            <p>Estudante de Ciência da Computação.</p>
                        </div>
                        <div class="col-lg-4 col-sm-6 text-center mb-4">
                            <img class="rounded-circle img-fluid d-block mx-auto" src="http://placehold.it/200x200" alt="">
                            <h3>Nick 2
                                <small>Cargo2</small>
                            </h3>
                            <p>Desc2</p>
                        </div>
                        <div class="col-lg-4 col-sm-6 text-center mb-4">
                            <img class="rounded-circle img-fluid d-block mx-auto" src="http://placehold.it/200x200" alt="">
                            <h3>Nick 3
                                <small>Cargo3</small>
                            </h3>
                            <p>Desc3</p>
                        </div>
                        <div class="col-lg-4 col-sm-6 text-center mb-4">
                            <img class="rounded-circle img-fluid d-block mx-auto" src="http://placehold.it/200x200" alt="">
                            <h3>Nick 4
                                <small>Cargo4</small>
                            </h3>
                            <p>Desc4</p>
                        </div>

                    </div>

                </div>
            </article>
            <div class="container bg-white">
                <!--
                <p class="lead">Essa é uma página dedicada a divulgação de um trabalho de conclusão de grau da 
                <b style="font-family: 'Gentium Book Basic';">Sociedade Brasileira de Eubiose</b>.</p>
                -->
                <blockquote class="blockquote">
                    <p class="mb-0">Fontes</p>
                    <div class="blockquote-footer">mcçpsdj~pc
                    </div>
                    <div class="blockquote-footer">dfvhgsdzxfhg
                    </div>
                </blockquote>
            </div>

        </main>
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">&copy; Estudio 537 &reg;</p>
            </div>
        </footer>
        <script src="js/jquery-3.4.1.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
    </body>

</html>
