<%-- 
    Document   : genPiadas
    Created on : 24/10/2019, 10:55:30
    Author     : Aluno
--%>

<%@page import="Entidades.Moderador"%>
<%@page import="Entidades.Usuario"%>
<%@page import="Controladoras.CtrPiada"%>
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
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <title>PiadasGer</title>
    </head>
    <!--onload="atualizaTabela()"-->
    <body onload="atualizaTabela()">
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

        <div class="conForm container">
            <div class="container">
                <div class="row align-items-center">
                    <label id="retorno"></label>
                </div>
            </div>
            <form name="formulario" id="formulario" method="POST" enctype="multipart/form-data">
                <div class="form-group row">
                    <!--<label for="cod" class="col-4 col-form-label">Código</label>-->
                    <div class="col-12">
                        <input id="cod" name="cod" placeholder="Código" type="text" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <!--<label for="cat" class="col-4 col-form-label">Categoria</label> -->
                    <div class="col-12">
                        <select id="cat" name="cat" class="custom-select" aria-describedby="catHelpBlock" required="required">
                            <!--<option value="rabbit">Rabbit</option>
                            <option value="duck">Duck</option>-->
                            <%= CtrPiada.getInstancia().getCategorias_html()%>
                        </select> 
                        <span id="catHelpBlock" class="form-text text-muted">Selecione uma Categoria!!!</span>
                    </div>
                </div>
                <div class="form-group row">
                    <!--<label class="col-4 col-form-label" for="tit_piada">Título da piada</label> -->
                    <div class="col-12">
                        <input id="tit_piada" name="tit_piada" placeholder="Título da Piada" type="text" class="form-control" aria-describedby="tit_piadaHelpBlock" required="required"> 
                        <span id="tit_piadaHelpBlock" class="form-text text-muted">Insira o titulo da piada</span>
                    </div>
                </div>
                <div class="form-group row">
                    <!--<label for="palChave" class="col-4 col-form-label">Palavra Chave</label> -->
                    <div class="col-12">
                        <input id="palChave" name="palChave" placeholder="Palavra Chave" type="text" class="form-control" aria-describedby="palChaveHelpBlock" required="required"> 
                        <span id="palChaveHelpBlock" class="form-text text-muted">Insira a palavra chave</span>
                    </div>
                </div>
                <div class="form-group row">
                    <!--<label for="texto" class="col-4 col-form-label">Texto</label>  -->
                    <div class="col-12">
                        <textarea id="texto" name="texto" cols="40" rows="5" class="form-control" aria-describedby="textoHelpBlock" placeholder="Insira o texto da Piada" required="required"></textarea> 
                        <span id="textoHelpBlock" class="form-text text-muted">Informe o texto da piada</span>
                    </div>
                </div> 
                <div class="form-group row">
                    <div class="col-12">
                        <input name="arquivo" type="file" accept=".png" id="arquivo" >
                    </div>
                </div>
            </form>
            <div class="form-group row">
                <div class="offset-4 col-8">
                    <button id="btnTesteSubmit" onclick="evtClkButon()" class="btn btn-primary">Salvar</button>
                </div>
            </div>
        </div>
        <div class="container mt-4 conForm">
            <div class="row bg-light">
                <div class="col-10">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" id="txbusca">
                </div>
                <div class="col-2">
                    <button class="btn btn-outline-success my-2 my-sm-0" onclick="atualizaTabela()">Buscar</button>
                </div>
            </div>
        </div>
        <div class="container mt-4 table-wrapper-scroll-y my-custom-scrollbar">
            <table class="table table bg-light table-bordered table-striped mb-0">
                <thead>
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Categoria</th>
                        <th scope="col">Titulo</th>
                        <th scope="col">Palavra Chave</th>
                        <th scope="col">Resumo</th>
                        <th scope="col" colspan="2">Operações</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
        <script src="js/jquery-3.4.1.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/genPiadasScripts.js" type="text/javascript"></script>
        <% }%>
    </body>
</html>
