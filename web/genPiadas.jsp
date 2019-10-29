<%-- 
    Document   : genPiadas
    Created on : 24/10/2019, 10:55:30
    Author     : Aluno
--%>

<%@page import="Controladoras.CtrPiada"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <title>PiadasGer</title>
    </head>
    <body onload="atualizaTabela()">

        <div class="conForm container">
            <form name="formulario" id="formulario" method="POST" onsubmit="submitFormulario()" enctype="multipart/form-data">
                <div class="form-group row">
                    <!--<label for="cod" class="col-4 col-form-label">Código</label>-->
                    <div class="col-12">
                        <input id="cod" name="cod" placeholder="Código" type="text" disabled="true" class="form-control">
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
                        <span id="tit_piadaHelpBlock" class="form-text text-muted">Insira o texto da piada</span>
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
                        <span id="textoHelpBlock" class="form-text text-muted">Informe a piada</span>
                    </div>
                </div> 
                <div class="form-group row">
                    <div class="col-12">
                        <input type="file" id="arquivo" name="arquivo">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="offset-4 col-8">
                        <button name="submit" type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
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
        <div class="container mt-4">
            <table class="table bg-light">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Categoria</th>
                        <th>Titulo</th>
                        <th>Palavra Chave</th>
                        <th>Resumo</th>
                        <th>Operações</th>
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
    </body>
</html>
