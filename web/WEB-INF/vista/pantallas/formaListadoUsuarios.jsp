<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
div.card{
  margin: 50px;
}
</style>

<script language="javascript" type="text/javascript">
function EliminarUsuario(strUsuarioName){
  return confirm("¿Desea eliminar el Usuario '" + strUsuarioName + "'?")
}
</script>

<script type="text/javascript" src="js/jquery.tablesorter.js"></script>

<h1 style="text-align:center;">
  <fmt:message key="formaListadoUsuarios.titulo" />
</h1>

<div class="fixed-action-btn">
  <a href="solicitarAgregarUsuario.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
</div>

<div class="card" id=cardT>
  <table class="striped" id="usuario">
    <thead>
      <tr>
        <th data-field="nombre">
          <a class="waves-effect" onclick="ordNombre('nombre');">
            <fmt:message key="formaListadoUsuarios.etiqueta.nombre" />
          </a>
        </th>
        <th data-field="descripcion">
          <a class="waves-effect" onclick="ordDescripcion('descripcion');">
            <fmt:message key="formaListadoUsuarios.etiqueta.descripcion" />
          </a>
        </th>
        <th data-field="precio">
          <a class="waves-effect" onclick="ordPrecio('precio');">
            <fmt:message key="formaListadoUsuarios.etiqueta.precio" />
          </a>
        </th>
        <th data-field="horario">
          <a class="waves-effect" onclick="ordHorario('horario');">
            <fmt:message key="formaListadoUsuarios.etiqueta.horario" />
          </a>
        </th>
        <th data-field="estado">
          <a class="waves-effect" onclick="ordEstado('estado');">
            <fmt:message key="formaListadoUsuarios.etiqueta.estado" />
          </a>
        </th>
        <th data-field="administracion">
          <fmt:message key="formaListadoUsuarios.etiqueta.administracion" />
        </th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="usuario" items="${formaListadoUsuarios.usuarios}">
        <tr>
          <td>

            <a class="waves-effect" href="#modal${usuario.id}">${usuario.nombre.nombre}</a>

            <div id="modal${usuario.id}" class="modal">
              <div class="modal-content">

                <div class="card">
                  <div class="card-image">
                    <img style="height: 100%; width: 100%;" src="images/user.png">
                    <span class="card-title">${usuario.nombre.nombre}</span>
                  </div>
                </div>


              </div>
            </div>

          </td>
          <td>${usuario.nombre.apellidoPaterno}</td>
          <td>${usuario.nombre.apellidoMaterno}</td>
          <td>${usuario.nombre.prefijo}</td>
          <td>${usuario.credencial.nombreUsuario}</td>
          <td>

            <a href='solicitarEditarUsuario.do?id=<c:out value="${usuario.id}"/>&apellidoPaterno=<c:out value="${usuario.nombre.apellidoPaterno}"/>&apellidoMaterno=<c:out value="${usuario.nombre.apellidoMaterno}"/>&prefijo=<c:out value="${usuario.nombre.prefijo}"/>&nombre=<c:out value="${usuario.nombre.nombre}"/>&nombreUsuario=<c:out value="${usuario.credencial.nombreUsuario}"/>&claveAcceso=<c:out value="${usuario.credencial.claveAcceso}"/>' class="waves-effect waves-light blue btn">
            <i class="material-icons left">mode_edit</i>
            <fmt:message key="formaListadoUsuarios.etiqueta.modificar" />
          </a>
          <a href='procesarEliminarUsuario.do?id=<c:out value="${usuario.id}"/>' class="waves-effect waves-light red btn" onClick="javascript: return EliminarUsuario('<c:out value="${usuario.getNombre()}"/>')">
          <i class="material-icons left">delete</i>
          <fmt:message key="formaListadoUsuarios.etiqueta.eliminar" />
        </a>
      </td>
    </tr>
  </c:forEach>
</tbody>
</table>
</div>

<script type="text/javascript">
  $(document).ready(function() {
    $("#usuario").tablesorter();
  } );
  $(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
  });

  function ordenarPor( attribute ) {
    console.log("Alex implementa un ajax aqui");
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
