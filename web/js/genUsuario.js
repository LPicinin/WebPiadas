/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function enviaFormUsuario()
{
    event.preventDefault(); // evita refresh da tela
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "executaEventoUsuario", true);
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var form = document.forms["fusuario"];
    var formData = new FormData(form);
    let data = "usr="+$('#usr').val()+"&pass="+$("#pass").val()+"&nivel="+$("input[name='nNivel']:checked").val();
    //let data = "";
    formData.append('evento', 'insert');
    
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            $('#alerta').html(xhttp.responseText);
        }
    };
    xhttp.send(data);
    /*
     * <div class="alert alert-danger" role="alert">
            This is a danger alert—check it out!
     * </div>
     * 
     */
}