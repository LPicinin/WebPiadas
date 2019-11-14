function IncReaction(reac, cod) 
{
    event.preventDefault(); // evita refresh da tela
    //alert(reac+"\t"+cod)
    
    jQuery.ajax({
        type: "POST",
        url: "executareaction?atr="+reac+"&cod="+cod,
        success: function (data)
        {
            var result = data;
            $('#c'+cod).html(result);

        }
    });
}

