<%-- 
    Document   : genPiadas
    Created on : 24/10/2019, 10:55:30
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <title>PiadasGer</title>

    </head>
    <body>

        <div class="conForm container">
            <form name="formulario" id="formulario">
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
                            <option value="rabbit">Rabbit</option>
                            <option value="duck">Duck</option>
                            <option value="fish">Fish</option>
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
                    <div class="offset-4 col-8">
                        <button name="submit" type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
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
                    <tr>
                        <td>1</td>
                        <td>Futebol</td>
                        <td>Glove</td>
                        <td>A busca da perereka má</td>
                        <td>xereka</td>
                        <td>
                            <img src="images/iconfinder_edit-paste_118923.svg"/>
                            <img src="images/iconfinder_edit-delete_118920.svg"/>
                        </td> <!-- limitar caracter -->
                    </tr>
                </tbody>
            </table>
        </div>

    </body>
</html>
