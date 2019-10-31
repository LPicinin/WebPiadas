/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

function inserePiada()
{

    event.preventDefault(); // evita refresh da tela
    let frm = $("#formulario");
    alert("insere");
    
    jQuery.ajax({
        type: "POST",
        url: "executaEvento",
        data: frm.serialize(),
        success: function (data) 
        {
            var result = data;
            $('#result').attr("value", result);
             alert("recebeu");

        }
    });
    /*
     var xhttp = new XMLHttpRequest();
     xhttp.open("POST", "executaEvento", true);
     xhttp.setRequestHeader("Content-Type", "multipart/form-data; charset=utf-8");
     let formData = new FormData(document.forms["formulario"]);
     formData.append("evento", "inserePiada");
     */
    /*let data = "evento=inserePiada&titulo=" + $("#tit_piada").val() + 
     "&palavraChave=" + $("#palChave").val() + 
     "&texto=" + $("#texto").val() +
     "&categoria=" + $("#cat").val()+
     //"&arquivo="+$("#arquivo").val();
     /*
     xhttp.onreadystatechange = function ()
     {
     if (xhttp.readyState === 4 && xhttp.status === 200)
     {
     $('tbody').html(xhttp.responseText);
     }
     };
     //alert(formData.toString())
     xhttp.send(formData);
     */
}

function editarPiada(td)
{
    let data = td.closest('tr').id.split("#");
    $('#cod').val(data[0]);
    $('#cat').val(data[1].valueOf());
    $('#tit_piada').val(data[2]);
    $('#palChave').val(data[3]);
    $('#texto').val(data[4]);
    $('#arquivo').val(data[5]);
}
function deletePiada(cod)
{
    event.preventDefault(); // evita refresh da tela
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "executaEvento", true);
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    let data = "evento=deletaPiada&cod=" + cod;
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            atualizaTabela()
        }
    };
    //alert(formData.toString())
    xhttp.send(data);


}
function submitFormulario()
{
    if ($("#cod").val() === '')
    {
        inserePiada();
    } else
    {
        editarPiada()
    }
}

function DataUpload(formUpload)
{
    alert(formUpload.arquivo)
    event.preventDefault(); // evita refresh da tela
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "executaEvento");
    var formData = new FormData(formUpload);
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            document.getElementById('preview').innerHTML = xhttp.responseText;
        }
    };
    xhttp.send(formData);
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