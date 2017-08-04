<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <style>
            .cuadro{
                display: inline-block;
                vertical-align: top;
                width: 250px;
            }
        </style>
    </head>
    <body>
        <input type="text" id="b">
        <input type="button" id="buscar" value="Buscar">
        <div id="imagenes"></div>
        <script src="js/jQuery.js"></script>
        <script>
            $(document).on("ready",main);
            function main(){
                $("#buscar").on("click",function(){
                    var texto = "";
                    var tag = $("#b").val();
                    $("#imagenes").text("Cargando...");
                    $.getJSON("http://api.flickr.com/services/feeds/photos_public.gne?tags="+tag+"&tagmode=any&format=json&jsoncallback=?",function(datos){
                        $.each(datos.items,function(i,item){
                            texto += "<div class='cuadro'>";
                            texto += "<h5>"+item.title+"</h5>";
                            texto += "<img src='"+item.media.m+"' />";
                            texto += "</div>";
                        });
                        $("#imagenes").html(texto);
                    });
                });
            }
        </script>
    </body>
</html>
