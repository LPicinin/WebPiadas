/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function evtBusca()
{
    return true;
}

function validaUsuario()
{
    event.preventDefault(); // evita refresh da tela
    //var form = document.forms["flogin"];
    var form = document.getElementById("flogin");
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "validaUsuario");
    var formData = new FormData(form);
    xhttp.send(formData);

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            document.getElementById('alerta').innerHTML = xhttp.responseText;
        }
    };
}