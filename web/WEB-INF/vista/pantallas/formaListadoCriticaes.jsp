<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
div.card{
  margin: 50px;
}
</style>

<script language="javascript" type="text/javascript">
function EliminarCritica(strCriticaName){
  return confirm("¿Desea eliminar el Critica '" + strCriticaName + "'?")
}
</script>

<script type="text/javascript" src="js/jquery.tablesorter.js"></script>

<h1 style="text-align:center;">
  <fmt:message key="formaListadoCriticaes.titulo" />
</h1>

<div class="fixed-action-btn">
  <a href="solicitarAgregarCritica.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
</div>

<div class="card" id=cardT>
  <table class="striped" id="critica">
    <thead>
      <tr>
        <th data-field="nombre">
          <a class="waves-effect" onclick="ordNombre('nombre');">
            <fmt:message key="formaListadoCriticaes.etiqueta.nombre" />
          </a>
        </th>
        <th data-field="descripcion">
          <a class="waves-effect" onclick="ordDescripcion('descripcion');">
            <fmt:message key="formaListadoCriticaes.etiqueta.descripcion" />
          </a>
        </th>
        <th data-field="hotel">
          <a class="waves-effect" onclick="ordHotel('hotel');">
            <fmt:message key="formaListadoCriticaes.etiqueta.hotel" />
          </a>
        </th>
        <th data-field="nivel">
          <a class="waves-effect" onclick="ordNivel('nivel');">
            <fmt:message key="formaListadoCriticaes.etiqueta.nivel" />
          </a>
        </th>
        <th data-field="administracion">
          <fmt:message key="formaListadoCriticaes.etiqueta.administracion" />
        </th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="critica" items="${formaListadoCriticaes.criticaes}">
        <tr>
          <td>

            <a class="waves-effect" href="#modal${critica.id}">${critica.nombre}</a>

            <div id="modal${critica.id}" class="modal">
              <div class="modal-content">

                <div class="card">
                  <div class="card-image">
                    <img style="height: 100%; width: 100%;" src="images/${critica.nivel}.png">
                    <span class="card-title">${critica.nombre}</span>
                  </div>
                </div>


              </div>
            </div>

          </td>
          <td>${critica.descripcion}</td>
          <td>${critica.hotel}</td>
          <td>${critica.nivel}</td>
          <td>

            <a href='solicitarModificarCritica.do?id=<c:out value="${critica.id}"/>&descripcion=<c:out value="${critica.descripcion}"/>&nombre=<c:out value="${critica.nombre}"/>&hotel=<c:out value="${critica.hotel}"/>&nivel=<c:out value="${critica.nivel}"/>' class="waves-effect waves-light blue btn">
            <i class="material-icons left">mode_edit</i>
            <fmt:message key="formaListadoCriticaes.etiqueta.modificar" />
          </a>
          <a href='procesarEliminarCritica.do?id=<c:out value="${critica.id}"/>' class="waves-effect waves-light red btn" onClick="javascript: return EliminarCritica('<c:out value="${critica.nombre}"/>')">
          <i class="material-icons left">delete</i>
          <fmt:message key="formaListadoCriticaes.etiqueta.eliminar" />
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
          document.getElementById("critica").innerHTML="Page not found";
      }
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
          document.getElementById("critica").innerHTML=xmlhttp.responseText;
      }
    };

    xmlhttp.open("GET","ordenarCriticaesPor.do?nombre=" + attribute , true );
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
  function ordHotel(){
   ordenarPor("Hotel");
  }
  function ordNivel(){
   ordenarPor("Nivel");
  }


</script>
