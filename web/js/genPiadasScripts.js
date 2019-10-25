/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function editarPiada()
{
    alert('Editar Pressionado');
}
function deletePiada()
{
    alert('Deletar Pressionado');
}

function atualizaTabela()
{
    event.preventDefault(); // evita refresh da tela
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "executaEvento", true);
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var form = document.forms["formulario"];
    var formData = new FormData(form);
    formData.append('evento', 'atualizaTabela');
    let data = "evento=atualizaTabela";
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            $('tbody').html(xhttp.responseText);
        }
    };
    //alert(formData.toString())
    xhttp.send(data);
}
/*
function atualizaTabela()
{
    let r = $("#txbusca").val();
    
    event.preventDefault(); // evita refresh da tela
    //var form = document.forms["formulario"];
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "executaEvento");
    
    let data = "evento="+"atualizaTabela";
    if($("#txbusca").val() !== '')
        data+="&chave="+$("#txbusca").val();
    alert(data);
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            $('tbody').html(xhttp.responseText);
        }
    };
    xhttp.send(data);
}
*/