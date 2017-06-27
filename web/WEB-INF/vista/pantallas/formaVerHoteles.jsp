<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>

<form>
        <div class="input-field">
          <input id="search" type="search" required>
          <label class="label-icon" for="search"><i class="material-icons">search</i></label>
          <i class="material-icons">close</i>
        </div>
      </form>


<h1>
  <fmt:message key="formaListadoHoteles.titulo" />
</h1>




 <div class="fixed-action-btn">
    <a href="solicitarAgregarHotel.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
  </div>

 <c:forEach var="hotel" items="${formaListadoHoteles.hoteles}">


      <div class="card horizontal">
        <div class="card-image">
          <img style="height: 100%; width: 100%;" src="${hotel.imagen}">
          <span class="card-title">${hotel.nombre}</span>

          <a href="procesarEliminarHotel.do?id=<c:out value="${hotel.id}"/>" class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">delete</i></a>
          <a href='solicitarModificarHotel.do?id=<c:out value="${hotel.id}"/>&descripcion=<c:out value="${hotel.descripcion}"/>&nombre=<c:out value="${hotel.nombre}"/>&precio=<c:out value="${hotel.precio}"/>&horario=<c:out value="${hotel.horario}"/>&estado=<c:out value="${hotel.estado}"/>&pais=<c:out value="${hotel.pais}"/>&direccion=<c:out value="${hotel.direccion}"/>&imagen=<c:out value="${hotel.imagen}"/>' style="left: 50px;" class="btn-floating halfway-fab waves-effect waves-light blue"><i class="material-icons">mode_edit</i></a>


        </div>
        <div class="card-stacked">
        <div class="card-content">
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoHoteles.etiqueta.precio" />
            </h5>
            <p class="col s6 m6 l6">
              ${hotel.precio}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoHoteles.etiqueta.horario" />
            </h5>
            <p class="col s6 m6 l6">
              ${hotel.horario}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoHoteles.etiqueta.estado" />
            </h5>
            <p class="col s6 m6 l6">
              ${hotel.estado}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoHoteles.etiqueta.pais" />
            </h5>
            <p class="col s6 m6 l6">
              ${hotel.pais}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoHoteles.etiqueta.direccion" />
            </h5>
            <p class="col s6 m6 l6">
              ${hotel.direccion}
            </p>
          </div>

          <a class="waves-effect waves-light blue btn" href="#descripcion${hotel.id}">
            Mas informacion
          </a>

          <div id="descripcion${hotel.id}" class="modal">
            <div class="modal-content">

              <div class="card">
                <div class="row">
                  <h5 class="col s6 m6 l6">
                    <fmt:message key="formaListadoHoteles.etiqueta.descripcion" />
                  </h5>
                  <p class="col s6 m6 l6">
                    ${hotel.descripcion}
                  </p>
                </div>
              </div>

            </div>
          </div>





        </div>
      </div>
      </div>

      </c:forEach>

      <script type="text/javascript">
        $(document).ready(function(){
          // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
          $('.modal').modal();
        });
      </script>
