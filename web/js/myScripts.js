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
    var form = document.forms["flogin"];
    //var form = document.getElementById("flogin");
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "validaUsuario");
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let data = "usr="+form["inputEmail"].value+"&pass="+form["inputPassword"].value;

    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            document.getElementById('alerta').innerHTML = xhttp.responseText;
        }
    };
    
    xhttp.send(data);
}

function validaUsuario0()
{
    event.preventDefault(); // evita refresh da tela
    var form = document.forms["flogin"];
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "validaUsuario");
    var formData = new FormData(form);


    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            document.getElementById('alerta').innerHTML = xhttp.responseText;
        }
    };
    xhttp.send(formData);
}

function validaUsuario1()
{
    event.preventDefault(); // evita refresh da tela
    var form = document.forms["flogin"];
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "validaUsuario");
    var formData = new FormData(form);
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            document.getElementById('alerta').innerHTML = xhttp.responseText;
        }
    };
    xhttp.send(formData);
}

function atualizaGridPiadas() 
{
    event.preventDefault(); // evita refresh da tela
    let frm = $("#formBusca");    
    jQuery.ajax(
    {
        type: "POST",
        url: "executaEvento?evento=atualizaGridPiada",
        data: frm.serialize(),
        success: function (data) 
        {
            $('#containerPiadas').html(data);
        }
    });
}
