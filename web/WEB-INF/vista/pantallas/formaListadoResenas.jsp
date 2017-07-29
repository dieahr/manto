<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
div.card{
  margin: 50px;
}
</style>

<script language="javascript" type="text/javascript">
function EliminarResena(strResenaName){
  return confirm("¿Desea eliminar la Reseña '" + strResenaName + "'?")
}
</script>

<script type="text/javascript" src="js/jquery.tablesorter.js"></script>

<h1 style="text-align:center;">
  <fmt:message key="formaListadoResena.titulo" />
</h1>

<div class="fixed-action-btn">
  <a href="solicitarAgregarResena.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
</div>

<div class="card" id=cardT>
  <table class="striped" id="resena">
    <thead>
      <tr>
        <th data-field="nombre">
          <a class="waves-effect" onclick="ordNombre('nombre');">
            <fmt:message key="formaListadoResena.etiqueta.nombre" />
          </a>
        </th>
        <th data-field="descripcion">
          <a class="waves-effect" onclick="ordDescripcion('descripcion');">
            <fmt:message key="formaListadoResena.etiqueta.descripcion" />
          </a>
        </th>
        <th data-field="estado">
          <a class="waves-effect" onclick="ordEstado('estado');">
            <fmt:message key="formaListadoResena.etiqueta.estado" />
          </a>
        </th>
        <th data-field="puntuacion">
          <a class="waves-effect" onclick="ordPuntuacion('puntuacion');">
            <fmt:message key="formaListadoResena.etiqueta.puntuacion" />
          </a>
        </th>
        <th data-field="administracion">
          <fmt:message key="formaListadoResena.etiqueta.administracion" />
        </th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="resena" items="${formaListadoResenas.resenas}">
        <tr>
          <td>

            <a class="waves-effect" href="#modal${resena.id}">${resena.nombre}</a>

            <div id="modal${resena.id}" class="modal">
              <div class="modal-content">

                <div class="card">
                  <div class="card-image">
                    <img style="height: 100%; width: 100%;" src="images/${resena.puntuacion}.png">
                    <span class="card-title">${resena.nombre}</span>
                  </div>
                </div>


              </div>
            </div>

          </td>
          <td>${resena.descripcion}</td>
          <td>${resena.estado}</td>
          <td>${resena.puntuacion}</td>
          <td>

            <a href='solicitarModificarResena.do?id=<c:out value="${resena.id}"/>&descripcion=<c:out value="${resena.descripcion}"/>&nombre=<c:out value="${resena.nombre}"/>&estado=<c:out value="${resena.estado}"/>&puntuacion=<c:out value="${resena.puntuacion}"/>' class="waves-effect waves-light blue btn">
            <i class="material-icons left">mode_edit</i>
            <fmt:message key="formaListadoResena.etiqueta.modificar" />
          </a>
          <a href='procesarEliminarResena.do?id=<c:out value="${resena.id}"/>' class="waves-effect waves-light red btn" onClick="javascript: return EliminarResena('<c:out value="${resena.nombre}"/>')">
          <i class="material-icons left">delete</i>
          <fmt:message key="formaListadoResena.etiqueta.eliminar" />
        </a>
      </td>
    </tr>
  </c:forEach>
</tbody>
</table>
</div>

<script type="text/javascript">
  /*$(document).ready(function() {
    $("#critica").tablesorter();
  } );*/
  $(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
  });

  function ordenarPor( attribute ) {
    var xmlhttp=new XMLHttpRequest();

    xmlhttp.onreadystatechange = function() {
      if(xmlhttp.status==404){
          document.getElementById("resena").innerHTML="Page not found";
      }
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
          document.getElementById("resena").innerHTML=xmlhttp.responseText;
      }
    };

    xmlhttp.open("GET","ordenarResenasPor.do?nombre=" + attribute , true );
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
  function ordEstado(){
   ordenarPor("Estado");
  }
  function ordPuntuacion(){
   ordenarPor("Puntuacion");
  }


</script>
