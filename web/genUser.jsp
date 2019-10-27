<%-- 
    Document   : genUser
    Created on : 27/10/2019, 11:51:52
    Author     : luish
--%>

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
        <div class="container">
            <div class="col-12 mt-5" id="alerta">
                
            </div>
            <form class="conFormUser" onsubmit="enviaFormUsuario()" name="fusuario" id="fusuario">
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
    </body>
</html>
