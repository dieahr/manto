<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<table class="striped" id="hotel">
  <thead>
    <tr>
      <th data-field="nombre">
        <a class="waves-effect" onclick="ordNombre();">
          <fmt:message key="formaListadoHoteles.etiqueta.nombre" />
        </a>
      </th>
      <th data-field="descripcion">
        <a class="waves-effect" onclick="ordDescripcion();">
          <fmt:message key="formaListadoHoteles.etiqueta.descripcion" />
        </a>
      </th>
      <th data-field="precio">
        <a class="waves-effect" onclick="ordPrecio();">
          <fmt:message key="formaListadoHoteles.etiqueta.precio" />
        </a>
      </th>
      <th data-field="horario">
        <a class="waves-effect" onclick="ordHorario();">
          <fmt:message key="formaListadoHoteles.etiqueta.horario" />
        </a>
      </th>
      <th data-field="estado">
        <a class="waves-effect" onclick="ordEstado();">
          <fmt:message key="formaListadoHoteles.etiqueta.estado" />
        </a>
      </th>
      <th data-field="pais">
        <a class="waves-effect" onclick="ordPais();">
          <fmt:message key="formaListadoHoteles.etiqueta.pais" />
        </a>
      </th>
      <th data-field="direccion">
        <a class="waves-effect" onclick="ordDireccion();">
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

<script type="text/javascript">
$(document).ready(function(){
  // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
  $('.modal').modal();
});
</script>
