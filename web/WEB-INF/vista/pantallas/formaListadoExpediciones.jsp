<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
div.card{
  margin: 50px;
}
</style>

<script language="javascript" type="text/javascript">
function EliminarExpedicion(strExpedicionName){
  return confirm("¿Desea eliminar la expedicion '" + strExpedicionName + "'?")
}
</script>

<script type="text/javascript" src="js/jquery.tablesorter.js"></script>

<h1 style="text-align:center;">
  <fmt:message key="formaListadoExpediciones.titulo" />
</h1>

<div class="fixed-action-btn">
  <a href="#" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
</div>

<div class="card" id=cardT>
  <table class="striped" id="expedicion">
    <thead>
      <tr>
        <th data-field="nombre">
          <a class="waves-effect" onclick="ordNombre('nombre');">
            <fmt:message key="formaListadoExpediciones.etiqueta.nombre" />
          </a>
        </th>
        <th data-field="descripcion">
          <a class="waves-effect" onclick="ordDescripcion('descripcion');">
            <fmt:message key="formaListadoExpediciones.etiqueta.descripcion" />
          </a>
        </th>
        <th data-field="precio">
          <a class="waves-effect" onclick="ordPrecio('cantidad');">
            <fmt:message key="formaListadoExpediciones.etiqueta.cantidad" />
          </a>
        </th>
        <th data-field="horario">
          <a class="waves-effect" onclick="ordHorario('lugar');">
            <fmt:message key="formaListadoExpediciones.etiqueta.lugar" />
          </a>
        </th>
        <th data-field="estado">
          <a class="waves-effect" onclick="ordEstado('estado');">
            <fmt:message key="formaListadoExpediciones.etiqueta.estado" />
          </a>
        </th>
        <th data-field="pais">
          <a class="waves-effect" onclick="ordPais('pais');">
            <fmt:message key="formaListadoExpediciones.etiqueta.pais" />
          </a>
        </th>
        <th data-field="direccion">
          <a class="waves-effect" onclick="ordDireccion('direccion');">
            <fmt:message key="formaListadoExpediciones.etiqueta.direccion" />
          </a>
        </th>
        <th data-field="direccion">
          <a class="waves-effect" onclick="ordDireccion('fecha');">
            <fmt:message key="formaListadoExpediciones.etiqueta.fecha" />
          </a>
        </th>
        <th data-field="direccion">
          <a class="waves-effect" onclick="ordDireccion('hora');">
            <fmt:message key="formaListadoExpediciones.etiqueta.hora" />
          </a>
        </th>
        <th data-field="administracion">
          <fmt:message key="formaListadoExpediciones.etiqueta.administracion" />
        </th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="restaurante" items="${formaListadoExpediciones.expediciones}">
        <tr>
          <td>

            <a class="waves-effect" href="#modal${expedicion.id}">${expedicion.nombre}</a>

            <div id="modal${expedicion.id}" class="modal">
              <div class="modal-content">

                <div class="card">
                  <div class="card-image">
                    <img style="height: 100%; width: 100%;" src="${expedicion.imagen}">
                    <span class="card-title">${expedicion.nombre}</span>
                  </div>
                </div>


              </div>
            </div>

          </td>
          <td>${expedicion.descripcion}</td>
          <td>${expedicion.cantidad}</td>
          <td>${expedicion.lugar}</td>
          <td>${expedicion.estado}</td>
          <td>${expedicion.pais}</td>
          <td>${expedicion.direccion}</td>
          <td>${expedicion.fecha}</td>
          <td>${expedicion.hora}</td>
          <td>

            <a href='solicitarModificarRestaurante.do?id=<c:out value="${restaurante.id}"/>&descripcion=<c:out value="${restaurante.descripcion}"/>&nombre=<c:out value="${restaurante.nombre}"/>&precio=<c:out value="${restaurante.precio}"/>&horario=<c:out value="${restaurante.horario}"/>&estado=<c:out value="${restaurante.estado}"/>&pais=<c:out value="${restaurante.pais}"/>&direccion=<c:out value="${restaurante.direccion}"/>&imagen=<c:out value="${restaurante.imagen}"/>' class="waves-effect waves-light blue btn">
            <i class="material-icons left">mode_edit</i>
            <fmt:message key="formaListadoRestaurantees.etiqueta.modificar" />
          </a>
          <a href='procesarEliminarRestaurante.do?id=<c:out value="${restaurante.id}"/>' class="waves-effect waves-light red btn" onClick="javascript: return EliminarRestaurante('<c:out value="${restaurante.nombre}"/>')">
          <i class="material-icons left">delete</i>
          <fmt:message key="formaListadoRestaurantees.etiqueta.eliminar" />
        </a>
      </td>
    </tr>
  </c:forEach>
</tbody>
</table>
</div>
        
<script type="text/javascript">
  /*$(document).ready(function() {
    $("#restaurante").tablesorter();
  } );*/
  $(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
//    $('.modal').modal();
  });

  function ordenarPor( attribute ) {
    var xmlhttp=new XMLHttpRequest();

    xmlhttp.onreadystatechange = function() {
      if(xmlhttp.status==404){
          document.getElementById("expedicion").innerHTML="Page not found";
      }
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
          document.getElementById("expedicion").innerHTML=xmlhttp.responseText;
      }
    };

    xmlhttp.open("GET","ordenarExpedicionesPor.do?nombre=" + attribute , true );
    xmlhttp.send();

    $(document).ready(function(){
      // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
      $('.modal').modal();
    });
  }

  function ordNombre(){
    ordenarPor("Nombre");
  }
  function ordDescripcion(){
   ordenarPor("Descripcion");
  }
  function ordCantidad(){
   ordenarPor("Cantidad de Personas");
  }
  function ordLugar(){
   ordenarPor("Lugar de encuentro");
  }
  function ordEstado(){
   ordenarPor("Estado");
  }
  function ordPais(){
   ordenarPor("Pais");
  }
  function ordDireccion(){
   ordenarPor("Direccion");
  }
  function ordFecha(){
   ordenarPor("Fecha");
  }
  function ordHora(){
   ordenarPor("Hora");
  }


</script>