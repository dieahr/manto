<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
  #txtCity{
      width: 100px;
  }
  #txtCountry{
      width: 100px;
  }
</style>

<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDrXf9CxNYGJnAoO1odTbpFBHYAONeIEKg&callback=initMap" async defer ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.2/jquery.js"></script>
  <script>
  var geocoder;
  var infowindow;
  var marker;
  window.onload = function () {
    var latLng = new google.maps.LatLng(16.7408929, -93.10159049999999);
    var opciones = {
      center: latLng,
      zoom: 5,
      mapTypeId: google.maps.MapTypeId.HYBRID
    };
    var map = new google.maps.Map(document.getElementById("mapa"), opciones);
    geocoder = new google.maps.Geocoder();
    infowindow = new google.maps.InfoWindow();
    google.maps.event.addListener(map, 'click', function (event) {
      geocoder.geocode({
        'latLng': event.latLng
      }, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          if (results[0]) {
            document.getElementById('direccion').value =  results[0].geometry.location;
            var a = results[0].formatted_address.split(',');
            document.getElementById('estado').value =  a[1].trim();

            var valor = a[2];
            var xmlhttp=new XMLHttpRequest();
            var v = valor.replace("MÃ©xico","Mexico");
            xmlhttp.onreadystatechange=function(){
              if(xmlhttp.status==404){
              }
              if (xmlhttp.readyState==4 && xmlhttp.status==200){
                  var d = xmlhttp.responseText.trim().replace(/\s/g, ',');
                  var d1 = d.split(',');
                  //alert(d1[0] + ":"  +d1[5] + ":" + d1[10]);
                  document.getElementById('pais').value =  d1[0];
              }
            };
            xmlhttp.open("GET","Service.do?pais="+valor,true);
            xmlhttp.send();
            if (marker) {
              marker.setPosition(event.latLng);
            } else {
              marker = new google.maps.Marker({
                position: event.latLng,
                map: map
              })
            }
            infowindow.setContent(results[0].formatted_address + '<br/> Horario: ' + results[0].geometry.location);
            infowindow.open(map, marker);
          } else {
            document.getElementById('direccion').value = 'No se encontraron resultados';
          }
        } else {
          document.getElementById('direccion').value = 'Geocodificación ha fallado debido a: ' + status;
        }
      });
    });
  }
</script>

<h1>
  <fmt:message key="formaNuevoExpedicion.titulo" />
</h1>

<div class="card horizontal">
  <div class="card-image">

<div id="mapa" style="height: 100%; width:40vw;"></div>

  </div>
  <div class="card-stacked">
  <div class="card-content">

    <form id="forma" action="procesarRegistroExpedicion.do" method="post" enctype="multipart/form-data">


        <div class="input-field">
          <i class="material-icons prefix">view_headline</i>
          <input type="text"
                 name="nombre"

                 maxlength="100"
                 value="${formaNuevoExpedicion.nombre}">
          <label for="icon_prefix">
            <fmt:message key="formaNuevoExpedicion.etiqueta.nombre" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">description</i>
          <input type="text"
                 name="descripcion"

                 maxlength="100"
                 value="${formaNuevoExpedicion.descripcion}">
          <label for="icon_telephone">
            <fmt:message key="formaNuevoExpedicion.etiqueta.descripcion" />
        </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">perm_identity</i>
          <input type="number" step='any'
                 name="cantidad"

                 maxlength="100"
                 value="${formaNuevoExpedicion.cantidad}">
          <label for="icon_prefix">
            <fmt:message key="formaNuevoExpedicion.etiqueta.cantidad" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">my_location</i>
          <input type="text"
                id="estado"
                name="estado"

                 maxlength="100"
                 value="${formaNuevoExpedicion.estado}">
          <label for="icon_prefix" class="active">
            <fmt:message key="formaNuevoExpedicion.etiqueta.estado" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">my_location</i>
          <input type="text"
                id="pais"
                name="pais"

                 maxlength="100"
                 value="${formaNuevoExpedicion.pais}">
          <label for="icon_telephone" class="active">
            <fmt:message key="formaNuevoExpedicion.etiqueta.pais" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">my_location</i>
          <input type="text"
                name="direccion"
                id="direccion"
                 maxlength="100"
                 value="${formaNuevoExpedicion.direccion}">
          <label for="icon_prefix" class="active">
            <fmt:message key="formaNuevoExpedicion.etiqueta.direccion" />
          </label>
        </div>
          
          <div class="input-field">
          <i class="material-icons prefix">today</i>
          <input type="text"
                name="fecha"

                 maxlength="100"
                 value="${formaNuevoExpedicion.fecha}">
          <label for="icon_prefix" class="active">
            <fmt:message key="formaNuevoExpedicion.etiqueta.fecha" />
          </label>
        </div>
          
          <div class="input-field">
          <i class="material-icons prefix">schedule</i>
          <input type="text"
                name="hora"

                 maxlength="100"
                 value="${formaNuevoExpedicion.hora}">
          <label for="icon_prefix" class="active">
            <fmt:message key="formaNuevoExpedicion.etiqueta.hora" />
          </label>
        </div>

<!--        <div class="file-field input-field">
    <div class="btn">
    <span>
    <fmt:message key="formaNuevoRestaurante.etiqueta.foto" />
    </span>
    <input type="file"
     name="imagen"
     value="${formaNuevoRestaurante.imagen}">
    </div>
    <div class="file-path-wrapper">
    <input class="file-path validate" type="text">
    </div>
    </div>-->

    <input class="waves-effect waves-light btn" type="submit"
    name="submit"
    value="Agregar"/>


    </form>

  </div>
</div>
</div>
    
    <script type="text/javascript">
    // Procesar resultados del webservice
    var APPIDkey = "2b92ac90c161a8b52a86175509113de9";
    $(document).ready(function(){
                $("#btnGetWeather").click(function(){
                    var requestData = $("#txtCity").val() + "," + $("#txtCountry").val();
                    var resultElement = $("#resultDiv");
                    $.ajax({
                        url: "http://api.openweathermap.org/data/2.5/weather",
                        method: "get",
                        data: {q: requestData, APPID: APPIDkey},
                        dataType: "json",
                        success: function(data){
                            resultElement.html("Clima: " + data.weather[0].main + "<br>" + "Descripcion: " + data.weather[0].description);
                        }
                    });
                });
            });
  </script>


            <label>Ciudad:</label>
            <input type="text" id="txtCity" />
            <label>Pais:</label>
            <input type="text" id="txtCountry" />
            <br><br>
        <input type="button" id="btnGetWeather" value="Obtener el clima local" class="waves-effect waves-light btn">
        <br><br>
        <div id="resultDiv">
            
        </div>
        <br><br>
