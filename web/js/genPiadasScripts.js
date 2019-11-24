/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var flag_update = false;

function atualizaTabela()
{
    //alert('atualiza tabela');
    //event.preventDefault(); // evita refresh da tela
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

function atualizaTabela2()
{
    //alert('atualiza tabela');
    //event.preventDefault(); // evita refresh da tela
    var filtro = $("#txbusca").val();
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "executaEvento", true);
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var form = document.forms["formulario"];
    var formData = new FormData(form);
    formData.append('evento', 'atualizaTabela');
    let data = "evento=atualizaTabela" + ((filtro === '') ? "" : ("&palchave=" + filtro));
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

function editarPiada(td)
{
    let data = td.closest('tr').id.split("#");
    $('#cod').val(data[0]);
    $('#cat').val(data[1].valueOf());
    $('#tit_piada').val(data[2]);
    $('#palChave').val(data[3]);
    $('#texto').val(data[4]);
    $('#arquivo').val(data[5]);
    flag_update = true;
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
            atualizaTabela();
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

function validaform ()
{
    let status = true;
    let codpiada = $('#cod').val();
    let codcat = $('#cat').val();
    let titulo = $('#tit_piada').val();
    let palchave = $('#palChave').val();
    let texto = $('#texto').val();
    let arquivo = $('#arquivo').val();
    
    if (titulo === '')
    {
        $('#tit_piada').css({'background-color': 'red'});
        status = false;
    } else
    {
        $('#tit_piada').css({'background-color': 'white'});
    }


    if (palchave === '')
    {
        $('#palChave').css({'background-color': 'red'});
        status = false;
    } else
    {
        $('#palChave').css({'background-color': 'white'});
    }

    if (texto === '')
    {
        $('#texto').css({'background-color': 'red'});
        status = false;
    } else
    {
        $('#texto').css({'background-color': 'white'});
    }

    if (arquivo === '' && codpiada === '')
    {
        $('#arquivo').css({'color': 'red'});
        status = false;
    } else
    {
        $('#arquivo').css({'color': 'white'});
    }
    
    
    
    return status;
}



////////////////////////////////////////Novo

function evtClkButon()
{
    if (validaform())
    {       
        let param = "";
        ajaxFormfunction(event, "");        
    }
    
    
    
    
    
   
}
function limpaForm()
{
    $('#cod').val("");
    $('#cat').val();
    $('#tit_piada').val("");
    $('#palChave').val("");
    $('#texto').val("");
    $('#arquivo').val(" ");
}

function ajaxFormfunction(event, params)
{
    //stop submit the form, we will post it manually.
    event.preventDefault();
    // Get form
    var form = $('#formulario')[0];

    // Create an FormData object 
    var data = new FormData(form);
    //alert(data.get('cat'));
    // If you want to add an extra field for the FormData
    //data.append("CustomField", "This is some extra data, testing");
    // disabled the submit button
    //$("#btnSubmit").prop("disabled", true);
    $.ajax(
            {
                type: "POST",
                enctype: 'multipart/form-data',
                url: "executaEvento" + params,
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data)
                {
                    $("#retorno").css("color: green;")
                    $("#retorno").html(data);
                    atualizaTabela();
                    limpaForm();
                },
                error: function (e)
                {
                    $("#retorno").css("color: red;")
                    $("#retorno").html(data)
                }
            });
}