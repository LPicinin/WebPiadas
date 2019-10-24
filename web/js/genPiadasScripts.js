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
    let r = $("#txbusca").val()
    alert(r);
    event.preventDefault(); // evita refresh da tela
    var form = document.forms["formulario"];
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "executaEvento");
    
    let data = "evento="+"atualizaTabela"+"&chave="+$("");

    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            $('tbody').html(xhttp.responseText);
        }
    };
    xhttp.send(data);
}
