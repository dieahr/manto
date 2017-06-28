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
  <fmt:message key="formaListadoRestaurantees.titulo" />
</h1>




 <div class="fixed-action-btn">
    <a href="solicitarAgregarRestaurante.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
  </div>

 <c:forEach var="restaurante" items="${formaListadoRestaurantees.restaurantees}">


      <div class="card horizontal">
        <div class="card-image">
          <img style="height: 100%; width: 100%;" src="${restaurante.imagen}">
          <span class="card-title">${restaurante.nombre}</span>

          <a href="procesarEliminarRestaurante.do?id=<c:out value="${restaurante.id}"/>" class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">delete</i></a>
          <a href='solicitarModificarRestaurante.do?id=<c:out value="${restaurante.id}"/>&descripcion=<c:out value="${restaurante.descripcion}"/>&nombre=<c:out value="${restaurante.nombre}"/>&precio=<c:out value="${restaurante.precio}"/>&horario=<c:out value="${restaurante.horario}"/>&estado=<c:out value="${restaurante.estado}"/>&pais=<c:out value="${restaurante.pais}"/>&direccion=<c:out value="${restaurante.direccion}"/>&imagen=<c:out value="${restaurante.imagen}"/>' style="left: 50px;" class="btn-floating halfway-fab waves-effect waves-light blue"><i class="material-icons">mode_edit</i></a>


        </div>
        <div class="card-stacked">
        <div class="card-content">
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoRestaurantees.etiqueta.precio" />
            </h5>
            <p class="col s6 m6 l6">
              ${restaurante.precio}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoRestaurantees.etiqueta.horario" />
            </h5>
            <p class="col s6 m6 l6">
              ${restaurante.horario}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoRestaurantees.etiqueta.estado" />
            </h5>
            <p class="col s6 m6 l6">
              ${restaurante.estado}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoRestaurantees.etiqueta.pais" />
            </h5>
            <p class="col s6 m6 l6">
              ${restaurante.pais}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoRestaurantees.etiqueta.direccion" />
            </h5>
            <p class="col s6 m6 l6">
              ${restaurante.direccion}
            </p>
          </div>

          <a class="waves-effect waves-light blue btn" href="#descripcion${restaurante.id}">
            Mas informacion
          </a>

          <div id="descripcion${restaurante.id}" class="modal">
            <div class="modal-content">

              <div class="card">
                <div class="row">
                  <h5 class="col s6 m6 l6">
                    <fmt:message key="formaListadoRestaurantees.etiqueta.descripcion" />
                  </h5>
                  <p class="col s6 m6 l6">
                    ${restaurante.descripcion}
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
