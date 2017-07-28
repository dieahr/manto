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
  <fmt:message key="formaListadoExpediciones.titulo" />
</h1>




 <div class="fixed-action-btn">
    <a href="solicitarAgregarExpedicion.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
  </div>

 <c:forEach var="expedicion" items="${formaListadoExpediciones.expediciones}">


      <div class="card horizontal">
        <div class="card-image">
          <span class="card-title">${expedicion.nombre}</span>

          <a href="procesarEliminarExpedicion.do?id=<c:out value="${expedicion.id}"/>" class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">delete</i></a>
          <a href='solicitarModificarExpedicion.do?id=<c:out value="${expedicion.id}"/>&descripcion=<c:out value="${expedicion.descripcion}"/>&nombre=<c:out value="${expedicion.nombre}"/>&cantidad=<c:out value="${expedicion.cantidad}"/>&estado=<c:out value="${expedicion.estado}"/>&pais=<c:out value="${expedicion.pais}"/>&direccion=<c:out value="${expedicion.direccion}"/>&fecha=<c:out value="${expedicion.fecha}"/>&hora=<c:out value="${expedicion.hora}"/>' style="left: 50px;" class="btn-floating halfway-fab waves-effect waves-light blue"><i class="material-icons">mode_edit</i></a>


        </div>
        <div class="card-stacked">
        <div class="card-content">
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoExpediciones.etiqueta.cantidad" />
            </h5>
            <p class="col s6 m6 l6">
              ${expedicion.cantidad}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoExpediciones.etiqueta.estado" />
            </h5>
            <p class="col s6 m6 l6">
              ${expedicion.estado}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoExpediciones.etiqueta.pais" />
            </h5>
            <p class="col s6 m6 l6">
              ${expedicion.pais}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoExpediciones.etiqueta.direccion" />
            </h5>
            <p class="col s6 m6 l6">
              ${expedicion.direccion}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoExpediciones.etiqueta.fecha" />
            </h5>
            <p class="col s6 m6 l6">
              ${expedicion.fecha}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoExpediciones.etiqueta.hora" />
            </h5>
            <p class="col s6 m6 l6">
              ${expedicion.hora}
            </p>
          </div>

          <a class="waves-effect waves-light blue btn" href="#descripcion${expedicion.id}">
            Mas informacion
          </a>

          <div id="descripcion${expedicion.id}" class="modal">
            <div class="modal-content">

              <div class="card">
                <div class="row">
                  <h5 class="col s6 m6 l6">
                    <fmt:message key="formaListadoExpediciones.etiqueta.descripcion" />
                  </h5>
                  <p class="col s6 m6 l6">
                    ${expedicion.descripcion}
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
