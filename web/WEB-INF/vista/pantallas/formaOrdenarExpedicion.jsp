<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<table class="striped" id="expedicion">
  <thead>
    <tr>
      <th data-field="nombre">
        <a class="waves-effect" onclick="ordNombre();">
          <fmt:message key="formaListadoExpediciones.etiqueta.nombre" />
        </a>
      </th>
      <th data-field="descripcion">
        <a class="waves-effect" onclick="ordDescripcion();">
          <fmt:message key="formaListadoExpediciones.etiqueta.descripcion" />
        </a>
      </th>
      <th data-field="cantidad">
        <a class="waves-effect" onclick="ordCantidad();">
          <fmt:message key="formaListadoExpediciones.etiqueta.cantidad" />
        </a>
      </th>
      <th data-field="estado">
        <a class="waves-effect" onclick="ordEstado();">
          <fmt:message key="formaListadoExpediciones.etiqueta.estado" />
        </a>
      </th>
      <th data-field="pais">
        <a class="waves-effect" onclick="ordPais();">
          <fmt:message key="formaListadoExpediciones.etiqueta.pais" />
        </a>
      </th>
      <th data-field="direccion">
        <a class="waves-effect" onclick="ordDireccion();">
          <fmt:message key="formaListadoExpediciones.etiqueta.direccion" />
        </a>
      </th>
      <th data-field="fecha">
        <a class="waves-effect" onclick="ordFecha();">
          <fmt:message key="formaListadoExpediciones.etiqueta.fecha" />
        </a>
      </th>
      <th data-field="hora">
        <a class="waves-effect" onclick="ordHora();">
          <fmt:message key="formaListadoExpediciones.etiqueta.hora" />
        </a>
      </th>
      <th data-field="administracion">
        <fmt:message key="formaListadoExpediciones.etiqueta.administracion" />
      </th>
    </tr>
  </thead>

  <tbody>
    <c:forEach var="expedicion" items="${formaListadoExpediciones.expediciones}">
      <tr>
        <td>

          <a class="waves-effect" href="#modal${expedicion.id}">${expedicion.nombre}</a>

          <div id="modal${expedicion.id}" class="modal">
            <div class="modal-content">


            </div>
          </div>

        </td>
        <td>${expedicion.descripcion}</td>
        <td>${expedicion.cantidad}</td>
        <td>${expedicion.estado}</td>
        <td>${expedicion.pais}</td>
        <td>${expedicion.direccion}</td>
        <td>${expedicion.fecha}</td>
        <td>${expedicion.hora}</td>
        <td>

          <a href='solicitarModificarExpedicion.do?id=<c:out value="${expedicion.id}"/>&descripcion=<c:out value="${expedicion.descripcion}"/>&nombre=<c:out value="${expedicion.nombre}"/>&cantidad=<c:out value="${expedicion.cantidad}"/>&estado=<c:out value="${expedicion.estado}"/>&pais=<c:out value="${expedicion.pais}"/>&direccion=<c:out value="${expedicion.direccion}"/>&fecha=<c:out value="${expedicion.fecha}"/>&hora=<c:out value="${expedicion.hora}"/>' class="waves-effect waves-light blue btn">
          <i class="material-icons left">mode_edit</i>
          <fmt:message key="formaListadoExpediciones.etiqueta.modificar" />
        </a>
        <a href='procesarEliminarExpedicion.do?id=<c:out value="${expedicion.id}"/>' class="waves-effect waves-light red btn" onClick="javascript: return EliminarExpedicion('<c:out value="${expedicion.nombre}"/>')">
        <i class="material-icons left">delete</i>
        <fmt:message key="formaListadoExpediciones.etiqueta.eliminar" />
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
