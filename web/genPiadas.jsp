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
        <title>PiadasGer</title>

    </head>
    <body>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <form>
            <div class="form-group row">
                <label for="cod" class="col-4 col-form-label">Código</label> 
                <div class="col-8">
                    <input id="cod" name="cod" placeholder="Código" type="text" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <label for="cat" class="col-4 col-form-label">Categoria</label> 
                <div class="col-8">
                    <select id="cat" name="cat" class="custom-select" aria-describedby="catHelpBlock" required="required">
                        <option value="rabbit">Rabbit</option>
                        <option value="duck">Duck</option>
                        <option value="fish">Fish</option>
                    </select> 
                    <span id="catHelpBlock" class="form-text text-muted">Selecione uma Categoria!!!</span>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-4 col-form-label" for="tit_piada">Título da piada</label> 
                <div class="col-8">
                    <input id="tit_piada" name="tit_piada" placeholder="Título da Piada" type="text" class="form-control" aria-describedby="tit_piadaHelpBlock" required="required"> 
                    <span id="tit_piadaHelpBlock" class="form-text text-muted">Insira o texto da piada</span>
                </div>
            </div>
            <div class="form-group row">
                <label for="palChave" class="col-4 col-form-label">Palavra Chave</label> 
                <div class="col-8">
                    <input id="palChave" name="palChave" placeholder="Palavra Chave" type="text" class="form-control" aria-describedby="palChaveHelpBlock" required="required"> 
                    <span id="palChaveHelpBlock" class="form-text text-muted">Insira a palavra chave</span>
                </div>
            </div>
            <div class="form-group row">
                <label for="texto" class="col-4 col-form-label">Texto</label> 
                <div class="col-8">
                    <textarea id="texto" name="texto" cols="40" rows="5" class="form-control" aria-describedby="textoHelpBlock" required="required"></textarea> 
                    <span id="textoHelpBlock" class="form-text text-muted">Informe a piada</span>
                </div>
            </div> 
            <div class="form-group row">
                <div class="offset-4 col-8">
                    <button name="submit" type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </form>
    </body>
</html>
