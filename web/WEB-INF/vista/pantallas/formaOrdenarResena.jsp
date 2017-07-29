<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
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

<script type="text/javascript">
$(document).ready(function(){
  // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
  $('.modal').modal();
});
</script>
