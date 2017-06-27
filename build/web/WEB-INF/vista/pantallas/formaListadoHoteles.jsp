<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
div.card{
  margin: 50px;
}
</style>

<script language="javascript" type="text/javascript">
function EliminarHotel(strHotelName){
  return confirm("¿Desea eliminar el Hotel '" + strHotelName + "'?")
}
</script>

<script type="text/javascript" src="js/jquery.tablesorter.js"></script>

<h1 style="text-align:center;">
  <fmt:message key="formaListadoHoteles.titulo" />
</h1>

<div class="fixed-action-btn">
  <a href="solicitarAgregarHotel.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
</div>

<div class="card" id=cardT>
  <table class="striped" id="hotel">
    <thead>
      <tr>
        <th data-field="nombre">
          <a class="waves-effect" onclick="ordNombre('nombre');">
            <fmt:message key="formaListadoHoteles.etiqueta.nombre" />
          </a>
        </th>
        <th data-field="descripcion">
          <a class="waves-effect" onclick="ordDescripcion('descripcion');">
            <fmt:message key="formaListadoHoteles.etiqueta.descripcion" />
          </a>
        </th>
        <th data-field="precio">
          <a class="waves-effect" onclick="ordPrecio('precio');">
            <fmt:message key="formaListadoHoteles.etiqueta.precio" />
          </a>
        </th>
        <th data-field="horario">
          <a class="waves-effect" onclick="ordHorario('horario');">
            <fmt:message key="formaListadoHoteles.etiqueta.horario" />
          </a>
        </th>
        <th data-field="estado">
          <a class="waves-effect" onclick="ordEstado('estado');">
            <fmt:message key="formaListadoHoteles.etiqueta.estado" />
          </a>
        </th>
        <th data-field="pais">
          <a class="waves-effect" onclick="ordPais('pais');">
            <fmt:message key="formaListadoHoteles.etiqueta.pais" />
          </a>
        </th>
        <th data-field="direccion">
          <a class="waves-effect" onclick="ordDireccion('direccion');">
            <fmt:message key="formaListadoHoteles.etiqueta.direccion" />
          </a>
        </th>
        <th data-field="administracion">
          <fmt:message key="formaListadoHoteles.etiqueta.administracion" />
        </th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="hotel" items="${formaListadoHoteles.hoteles}">
        <tr>
          <td>

            <a class="waves-effect" href="#modal${hotel.id}">${hotel.nombre}</a>

            <div id="modal${hotel.id}" class="modal">
              <div class="modal-content">

                <div class="card">
                  <div class="card-image">
                    <img style="height: 100%; width: 100%;" src="${hotel.imagen}">
                    <span class="card-title">${hotel.nombre}</span>
                  </div>
                </div>


              </div>
            </div>

          </td>
          <td>${hotel.descripcion}</td>
          <td>${hotel.precio}</td>
          <td>${hotel.horario}</td>
          <td>${hotel.estado}</td>
          <td>${hotel.pais}</td>
          <td>${hotel.direccion}</td>
          <td>

            <a href='solicitarModificarHotel.do?id=<c:out value="${hotel.id}"/>&descripcion=<c:out value="${hotel.descripcion}"/>&nombre=<c:out value="${hotel.nombre}"/>&precio=<c:out value="${hotel.precio}"/>&horario=<c:out value="${hotel.horario}"/>&estado=<c:out value="${hotel.estado}"/>&pais=<c:out value="${hotel.pais}"/>&direccion=<c:out value="${hotel.direccion}"/>&imagen=<c:out value="${hotel.imagen}"/>' class="waves-effect waves-light blue btn">
            <i class="material-icons left">mode_edit</i>
            <fmt:message key="formaListadoHoteles.etiqueta.modificar" />
          </a>
          <a href='procesarEliminarHotel.do?id=<c:out value="${hotel.id}"/>' class="waves-effect waves-light red btn" onClick="javascript: return EliminarHotel('<c:out value="${hotel.nombre}"/>')">
          <i class="material-icons left">delete</i>
          <fmt:message key="formaListadoHoteles.etiqueta.eliminar" />
        </a>
      </td>
    </tr>
  </c:forEach>
</tbody>
</table>
</div>

<script type="text/javascript">
  /*$(document).ready(function() {
    $("#hotel").tablesorter();
  } );*/
  $(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
  });

  function ordenarPor( attribute ) {
    var xmlhttp=new XMLHttpRequest();

    xmlhttp.onreadystatechange = function() {
      if(xmlhttp.status==404){
          document.getElementById("hotel").innerHTML="Page not found";
      }
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
          document.getElementById("hotel").innerHTML=xmlhttp.responseText;
      }
    };

    xmlhttp.open("GET","ordenarHotelesPor.do?nombre=" + attribute , true );
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
  function ordPrecio(){
   ordenarPor("Precio");
  }
  function ordHorario(){
   ordenarPor("Horario");
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


</script>
